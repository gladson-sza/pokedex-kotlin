package br.com.egsys.pokedexegsys.data.datasource.service

import br.com.egsys.pokedexegsys.data.model.PokemonSpecie
import br.com.egsys.pokedexegsys.data.model.PokedexEntries
import br.com.egsys.pokedexegsys.data.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexService {

    /**
      *   1 -> National dex ID
     */
    @GET("pokedex/1")
    suspend fun fetchNationalDex(): PokedexEntries

    @GET("pokemon/{id}")
    suspend fun fetchPokemonById(
        @Path("id") id: Int
    ): Pokemon

    /**
     * This route returns Pokedex Entries
     */
    @GET("pokemon-species/{id}")
    suspend fun fetchPokemonSpecieById(
        @Path("id") id: Int
    ): PokemonSpecie



}