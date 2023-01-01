package br.com.gladson.pokedex.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.gladson.pokedex.data.datasource.dao.AbilityDao
import br.com.gladson.pokedex.data.datasource.dao.PokemonDao
import br.com.gladson.pokedex.data.model.storage.Ability
import br.com.gladson.pokedex.data.model.storage.Pokemon


@Database(entities = [Pokemon::class, Ability::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun abilityDao(): AbilityDao

    companion object {
        private const val APP_DB_NAME = "pokedex_egsys.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        APP_DB_NAME
                    ).build()
                }

                return instance
            }
        }
    }
}