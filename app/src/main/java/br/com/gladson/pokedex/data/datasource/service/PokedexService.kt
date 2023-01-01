package br.com.gladson.pokedex.data.datasource.service

import br.com.gladson.pokedex.data.model.network.PokemonSpecie
import br.com.gladson.pokedex.data.model.network.PokedexEntries
import br.com.gladson.pokedex.data.model.network.PokemonDex
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexService {

    /**
     *   1 -> National dex ID
     */
    @GET("pokedex/1")
    suspend fun fetchNationalDex(): PokedexEntries

    /**
     * This route is to get pokedex text entries
     */
    @GET("pokemon-species/{id}")
    suspend fun fetchPokemonSpecieById(
        @Path("id") id: Int
    ): PokemonSpecie

    @GET("pokemon/{id}")
    suspend fun fetchPokemonById(
        @Path("id") id: Int
    ): PokemonDex




}