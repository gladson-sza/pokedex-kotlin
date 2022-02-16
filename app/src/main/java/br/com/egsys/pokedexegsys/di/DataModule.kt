package br.com.egsys.pokedexegsys.di

import android.util.Log
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object DataModule {
    private const val OK_HTTP = "OkHttp"
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    fun getModules() = listOf(
        networkModules(),
        databaseModule(),
        repositoryModule(),
    )

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

    private fun networkModules() = module {
        single {
            val interceptor = HttpLoggingInterceptor {
                Log.i(OK_HTTP, it)
            }

            interceptor.level = HttpLoggingInterceptor.Level.BODY

            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }

        single { MoshiConverterFactory.create(Moshi.Builder().build()) }
    }

    private fun databaseModule() = module {

    }

    private fun repositoryModule() = module {

    }
}