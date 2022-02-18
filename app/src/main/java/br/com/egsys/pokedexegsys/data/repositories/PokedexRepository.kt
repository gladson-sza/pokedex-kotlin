package br.com.egsys.pokedexegsys.data.repositories

import br.com.egsys.pokedexegsys.data.model.network.PokedexEntries
import br.com.egsys.pokedexegsys.data.model.network.PokemonDex
import br.com.egsys.pokedexegsys.data.model.network.PokemonEntry
import br.com.egsys.pokedexegsys.data.model.network.PokemonSpecie
import br.com.egsys.pokedexegsys.data.model.storage.Ability
import br.com.egsys.pokedexegsys.data.model.storage.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    fun fetchEntriesFromApi(): Flow<PokedexEntries>
    fun insertOnDatabase(pokemon: List<PokemonEntry>): Flow<Unit>
    fun searchPokemon(query: String): Flow<List<Pokemon>>
    fun getAllByNationalDex(): Flow<List<Pokemon>>
    fun getAllByName(): Flow<List<Pokemon>>
    fun getAllByType(): Flow<List<Pokemon>>
    fun getPokemonData(id: Int): Flow<Pair<Pokemon, List<Ability>>>
}