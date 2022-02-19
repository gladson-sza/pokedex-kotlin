package br.com.egsys.pokedexegsys.data.repositories

import android.database.sqlite.SQLiteException
import br.com.egsys.pokedexegsys.data.datasource.dao.AbilityDao
import br.com.egsys.pokedexegsys.data.datasource.dao.PokemonDao
import br.com.egsys.pokedexegsys.data.datasource.service.PokedexService
import br.com.egsys.pokedexegsys.data.model.SortMode
import br.com.egsys.pokedexegsys.data.model.StatName
import br.com.egsys.pokedexegsys.data.model.network.*
import br.com.egsys.pokedexegsys.data.model.storage.Ability
import br.com.egsys.pokedexegsys.data.model.storage.Pokemon
import br.com.egsys.pokedexegsys.data.model.storage.Stats
import br.com.egsys.pokedexegsys.exceptions.DatabaseException
import br.com.egsys.pokedexegsys.exceptions.NetworkException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException


class PokedexRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val abilityDao: AbilityDao,
    private val service: PokedexService,
) : PokedexRepository {
    override fun fetchEntriesFromApi(): Flow<PokedexEntries> = flow {
        try {
            val dexEntries = service.fetchNationalDex()
            emit(dexEntries)
        } catch (ex: HttpException) {
            throw NetworkException(ex.message ?: "Cannot fetch pokemon entries")
        }
    }

    override fun insertOnDatabase(pokemon: List<PokemonEntry>): Flow<Int> = flow {
        try {
            val pkmList = mutableListOf<Pokemon>()
            val abilityList = mutableListOf<Ability>()
            var count = 0

            pokemon.forEach {
                val pkmDex = service.fetchPokemonById(it.entry_number)
                val pkmSpecie = service.fetchPokemonSpecieById(it.entry_number)
                val statsMap = HashMap<String, Int>()

                pkmDex.abilities.forEach { pkmAbility ->
                    abilityList.add(
                        Ability(
                            name = pkmAbility.ability.name,
                            pokemonId = it.entry_number
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

                pkmList.add(
                    Pokemon(
                        it.entry_number,
                        pkmDex.name,
                        pkmDex.weight,
                        pkmDex.height,
                        pkmSpecie.flavor_text_entries.first().flavor_text,
                        type1,
                        type2,
                        baseStats
                    )
                )

                emit(++count)
            }

            pokemonDao.insertAll(*pkmList.toTypedArray())
            abilityDao.insertAll(*abilityList.toTypedArray())


        } catch (ex: HttpException) {
            throw NetworkException(ex.message ?: "Cannot fetch pokemon entries")
        } catch (ex: SQLiteException) {
            throw DatabaseException(ex.message ?: "Cannot insert on database")
        }
    }

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