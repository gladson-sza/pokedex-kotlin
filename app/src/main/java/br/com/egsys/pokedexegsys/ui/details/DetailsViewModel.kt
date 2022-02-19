package br.com.egsys.pokedexegsys.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.egsys.pokedexegsys.data.datasource.AppPreference
import br.com.egsys.pokedexegsys.data.model.storage.Ability
import br.com.egsys.pokedexegsys.data.model.storage.Pokemon
import br.com.egsys.pokedexegsys.data.repositories.PokedexRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val repository: PokedexRepository,
    preferences: AppPreference
) : ViewModel() {

    private val _pokemonData = MutableLiveData<PokemonDataState>()
    val pokemonData: LiveData<PokemonDataState> = _pokemonData

    private var _currentPokemonId = 0
    val currentPokemonId get() = _currentPokemonId

    val minPokemonId = 1
    val maxPokemonId = preferences.getEntryQuantity()

    fun loadPokemonData(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        _currentPokemonId = id

        repository.getPokemonData(id).onStart {
            _pokemonData.postValue(PokemonDataState.Loading)
        }.catch {
            _pokemonData.postValue(PokemonDataState.Error(it))
        }.first {
            _pokemonData.postValue(PokemonDataState.Success(it))
            return@first true
        }
    }

    fun loadNextPokemon() {
        if (_currentPokemonId < maxPokemonId) {
            loadPokemonData(_currentPokemonId + 1)
        }
    }

    fun loadPreviousPokemon() {
        if (_currentPokemonId > minPokemonId) {
            loadPokemonData(_currentPokemonId - 1)
        }
    }

    sealed class PokemonDataState {
        object Loading : PokemonDataState()
        data class Success(val pokemonData: Pair<Pokemon, List<Ability>>) : PokemonDataState()
        data class Error(val error: Throwable) : PokemonDataState()
    }
}