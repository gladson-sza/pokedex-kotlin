package br.com.gladson.pokedex.data.repositories

import android.database.sqlite.SQLiteException
import br.com.gladson.pokedex.data.datasource.dao.AbilityDao
import br.com.gladson.pokedex.data.datasource.dao.PokemonDao
import br.com.gladson.pokedex.data.datasource.service.PokedexService
import br.com.gladson.pokedex.data.model.SortMode
import br.com.gladson.pokedex.data.model.StatName
import br.com.gladson.pokedex.data.model.network.*
import br.com.gladson.pokedex.data.model.storage.Ability
import br.com.gladson.pokedex.data.model.storage.Pokemon
import br.com.gladson.pokedex.data.model.storage.Stats
import br.com.gladson.pokedex.exceptions.DatabaseException
import br.com.gladson.pokedex.exceptions.NetworkException
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException


class PokedexRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val abilityDao: AbilityDao,
    private val service: PokedexService,
) : PokedexRepository {
    private val dexLimitSize = 151

    override fun fetchEntriesFromApi(): Flow<PokedexEntries> = flow {
        try {
            val dexEntries = service.fetchNationalDex()
            val dexEntriesLimited = dexEntries.pokemon_entries.subList(0, dexLimitSize)
            emit(PokedexEntries(dexEntriesLimited))
        } catch (ex: HttpException) {
            throw NetworkException(ex.message ?: "Cannot fetch pokemon entries")
        }
    }

    private suspend fun getData(entryNumber: Int): Pair<Pokemon, List<Ability>> {
        val pkmDex = service.fetchPokemonById(entryNumber)
        val pkmSpecie = service.fetchPokemonSpecieById(entryNumber)
        val abilities = mutableListOf<Ability>()
        val statsMap = HashMap<String, Int>()

        pkmDex.abilities.forEach { pkmAbility ->
            abilities.add(
                Ability(
                    name = pkmAbility.ability.name,
                    pokemonId = entryNumber
                )
            )
        }

        pkmDex.stats.forEach { pkmStat ->
            statsMap[pkmStat.stat.name] = pkmStat.base_stat
        }

        val baseStats = Stats(
            hp = statsMap[StatName.HP.value],
            attack = statsMap[StatName.ATTACK.value],
            defense = statsMap[StatName.DEFENSE.value],
            spAttack = statsMap[StatName.SPECIAL_ATTACK.value],
            spDefense = statsMap[StatName.SPECIAL_DEFENSE.value],
            speed = statsMap[StatName.SPEED.value],
        )

        val type1: String = pkmDex.types.first().type.name
        var type2: String? = null

        if (pkmDex.types.size > 1) {
            type2 = pkmDex.types[1].type.name
        }

        return Pair(
            Pokemon(
                entryNumber,
                pkmDex.name,
                pkmDex.weight,
                pkmDex.height,
                pkmSpecie.flavor_text_entries.first().flavor_text,
                type1,
                type2,
                baseStats
            ), abilities
        )
    }

    /**
     * Fetch a pokémon data by a given pokémon entry list, then exec all requests async emitting
     * the entry counter.
     *
     * After wait all the results, the pokémon data is persisted locally then is emitted one last
     * counter that indicates that the data was persisted
     */
    override fun insertOnDatabase(pokemon: List<PokemonEntry>): Flow<Int> = flow {
        try {
            val pkmList = mutableListOf<Deferred<Pair<Pokemon, List<Ability>>>>()
            var count = 0

            coroutineScope {
                pokemon.forEach { pokemonEntry ->
                    val pkm = async {
                        getData(pokemonEntry.entry_number)
                    }
                    pkmList.add(pkm)
                    emit(++count)
                }
            }

            val (pkms, abilities) = pkmList.awaitAll().toList().unzip()
            pokemonDao.insertAll(*pkms.toTypedArray())
            abilities.forEach { abilityDao.insertAll(*it.toTypedArray()) }

            emit(pkmList.awaitAll().size + 1)
        } catch (ex: HttpException) {
            throw NetworkException(ex.message ?: "Cannot fetch pokemon entries")
        } catch (ex: SQLiteException) {
            throw DatabaseException(ex.message ?: "Cannot insert on database")
        }
    }

    /**
     * Do a search based on a query and a given SortMode
     */
    override fun searchPokemon(query: String, sortMode: SortMode): Flow<List<Pokemon>> = flow {
        try {
            val pokemon = when (sortMode) {
                SortMode.DEX -> pokemonDao.findByNameAndIdDexSort(query)
                SortMode.ALPHABETIC -> pokemonDao.findByNameAndIdNameSort(query)
                SortMode.TYPE -> pokemonDao.findByNameAndIdTypeSort(query)
            }

            emit(pokemon)
        } catch (ex: SQLiteException) {
            throw DatabaseException(ex.message ?: "Cannot insert on database")
        }
    }

    /**
     * Get all stored pokémon data and sort by a given SortMode
     */
    override fun getAllPokemon(sortMode: SortMode): Flow<List<Pokemon>> = flow {
        try {
            val pokemon = when (sortMode) {
                SortMode.DEX -> pokemonDao.findAllSortedByDexNational()
                SortMode.ALPHABETIC -> pokemonDao.findAllSortedByName()
                SortMode.TYPE -> pokemonDao.findAllSortedByType()
            }

            emit(pokemon)
        } catch (ex: SQLiteException) {
            throw DatabaseException(ex.message ?: "Cannot find on database")
        }
    }

    /**
     * Get a single pokémon data by id and returns a Pair with Pokemon and a list of his abilities
     *
     * @param id: (Pokémon dex entry)
     */
    override fun getPokemonData(id: Int): Flow<Pair<Pokemon, List<Ability>>> = flow {
        try {
            val pokemon = pokemonDao.findById(id)
            val abilities = abilityDao.findByPokemon(id)
            emit(Pair(pokemon, abilities))
        } catch (ex: SQLiteException) {
            throw DatabaseException(ex.message ?: "Cannot find on database")
        }
    }


}