package br.com.egsys.pokedexegsys.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.egsys.pokedexegsys.data.model.SortMode
import br.com.egsys.pokedexegsys.data.model.storage.Pokemon
import br.com.egsys.pokedexegsys.data.repositories.PokedexRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PokedexRepository
) : ViewModel() {

    private val _pokemonData = MutableLiveData<PokemonDataState>()
    val pokemonData: LiveData<PokemonDataState> = _pokemonData

    private var _sortMode = SortMode.DEX

    fun loadPokemonData() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAllPokemon(_sortMode).onStart {
            _pokemonData.postValue(PokemonDataState.Loading)
        }.catch {
            _pokemonData.postValue(PokemonDataState.Error(it))
        }.first {
            _pokemonData.postValue(PokemonDataState.Success(it))
            return@first true
        }

    }

    fun setSortMode(sortType: SortMode) {
        _sortMode = sortType
    }

    sealed class PokemonDataState {
        object Loading : PokemonDataState()
        data class Success(val pokemonList: List<Pokemon>) : PokemonDataState()
        data class Error(val error: Throwable) : PokemonDataState()
    }


}