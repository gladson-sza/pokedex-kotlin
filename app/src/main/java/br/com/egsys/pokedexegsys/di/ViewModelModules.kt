package br.com.egsys.pokedexegsys.di

import br.com.egsys.pokedexegsys.ui.details.DetailsViewModel
import br.com.egsys.pokedexegsys.ui.home.HomeViewModel
import br.com.egsys.pokedexegsys.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModules {

    /**
     * ViewModel inject classes
     */
    fun getModules() = module {
        viewModel { SplashViewModel(get(), get()) }
        viewModel { HomeViewModel(get()) }
        viewModel { DetailsViewModel(get(), get()) }
    }
}