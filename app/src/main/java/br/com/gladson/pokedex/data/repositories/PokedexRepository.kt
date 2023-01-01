package br.com.gladson.pokedex.data.repositories

import br.com.gladson.pokedex.data.model.SortMode
import br.com.gladson.pokedex.data.model.network.PokedexEntries
import br.com.gladson.pokedex.data.model.network.PokemonEntry
import br.com.gladson.pokedex.data.model.storage.Ability
import br.com.gladson.pokedex.data.model.storage.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    fun fetchEntriesFromApi(): Flow<PokedexEntries>
    fun insertOnDatabase(pokemon: List<PokemonEntry>): Flow<Int>
    fun searchPokemon(query: String, sortMode: SortMode): Flow<List<Pokemon>>
    fun getAllPokemon(sortMode: SortMode): Flow<List<Pokemon>>
    fun getPokemonData(id: Int): Flow<Pair<Pokemon, List<Ability>>>
}