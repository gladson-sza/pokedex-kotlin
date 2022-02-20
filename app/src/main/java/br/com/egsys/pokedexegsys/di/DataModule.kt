package br.com.egsys.pokedexegsys.di

import android.util.Log
import br.com.egsys.pokedexegsys.data.datasource.AppDatabase
import br.com.egsys.pokedexegsys.data.datasource.AppPreference
import br.com.egsys.pokedexegsys.data.datasource.service.PokedexService
import br.com.egsys.pokedexegsys.data.repositories.PokedexRepository
import br.com.egsys.pokedexegsys.data.repositories.PokedexRepositoryImpl
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
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

    /**
     * Create a retrofit service from a retrofit noted interface
     */
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

    /**
     * Create network modules related
     */
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
        single { createService<PokedexService>(get(), get()) }
    }

    /**
     * Create offline storage related modules
     */
    private fun databaseModule() = module {
        single { AppDatabase.getInstance(androidContext()).pokemonDao() }
        single { AppDatabase.getInstance(androidContext()).abilityDao() }
        single { AppPreference(androidContext()) }
    }

    /**
     * Create repository modules
     */
    private fun repositoryModule() = module {
        single<PokedexRepository> { PokedexRepositoryImpl(get(), get(), get()) }
    }
}