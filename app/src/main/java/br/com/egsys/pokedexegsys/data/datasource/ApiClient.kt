package br.com.egsys.pokedexegsys.data.datasource

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    private inline fun <reified T> createService(
        client: OkHttpClient,
        factory: MoshiConverterFactory
    ): T {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(factory)
            .build()
            .create(T::class.java)
    }
}