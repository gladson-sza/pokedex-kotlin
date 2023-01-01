package br.com.gladson.pokedex.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gladson.pokedex.data.model.SortMode
import br.com.gladson.pokedex.data.model.storage.Pokemon
import br.com.gladson.pokedex.data.repositories.PokedexRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PokedexRepository
) : ViewModel() {

    private val _pokemonData = MutableLiveData<PokemonDataState>()
    val pokemonData: LiveData<PokemonDataState> = _pokemonData

    private var _sortMode = SortMode.DEX

    /**
     * Changes the state of sort mode variable
     */
    fun setSortMode(sortType: SortMode) {
        _sortMode = sortType
    }

    /**
     * Load pokémon data based on current sort mode
     * If Sort mode was not changed, the default sort mode will be DEX
     */
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

    /**
     * Do a search based on pokémon name
     */
    fun search(query: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.searchPokemon(query, _sortMode).onStart {
            _pokemonData.postValue(PokemonDataState.Loading)
        }.catch {
            _pokemonData.postValue(PokemonDataState.Error(it))
        }.first {
            _pokemonData.postValue(PokemonDataState.Success(it))
            return@first true
        }
    }

    sealed class PokemonDataState {
        object Loading : PokemonDataState()
        data class Success(val pokemonList: List<Pokemon>) : PokemonDataState()
        data class Error(val error: Throwable) : PokemonDataState()
    }


}