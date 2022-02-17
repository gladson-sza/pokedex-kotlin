package br.com.egsys.pokedexegsys.di

import br.com.egsys.pokedexegsys.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModules {
    fun getModules() = module {
        viewModel { SplashViewModel(get(), get()) }
    }
}