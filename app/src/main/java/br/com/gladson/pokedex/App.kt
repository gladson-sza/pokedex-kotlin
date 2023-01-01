package br.com.gladson.pokedex

import android.app.Application
import br.com.gladson.pokedex.di.DataModule
import br.com.gladson.pokedex.di.ViewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(DataModule.getModules())
            modules(ViewModelModules.getModules())
        }
    }
}