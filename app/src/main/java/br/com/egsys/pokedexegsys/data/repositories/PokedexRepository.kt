package br.com.egsys.pokedexegsys.data.repositories

import br.com.egsys.pokedexegsys.data.model.PokemonEntry
import br.com.egsys.pokedexegsys.data.model.Pokemon

interface PokedexRepository {
    fun fetchEntries(): List<PokemonEntry>
    fun fetchEveryPokemonData(): List<PokemonEntry>
    fun loadFromLocalDatabase(): List<Pokemon>
}