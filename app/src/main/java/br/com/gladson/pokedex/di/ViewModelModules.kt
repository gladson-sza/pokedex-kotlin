package br.com.gladson.pokedex.di

import br.com.gladson.pokedex.ui.details.DetailsViewModel
import br.com.gladson.pokedex.ui.home.HomeViewModel
import br.com.gladson.pokedex.ui.splash.SplashViewModel
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