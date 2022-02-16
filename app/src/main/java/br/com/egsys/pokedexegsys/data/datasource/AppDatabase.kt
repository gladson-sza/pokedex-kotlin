package br.com.egsys.pokedexegsys.data.datasource

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {
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