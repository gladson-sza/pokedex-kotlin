package br.com.egsys.pokedexegsys

import android.app.Application
import br.com.egsys.pokedexegsys.di.DataModule
import br.com.egsys.pokedexegsys.di.ViewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(DataModule.getModules())
            modules(ViewModelModules.getModules())
        }
    }
}