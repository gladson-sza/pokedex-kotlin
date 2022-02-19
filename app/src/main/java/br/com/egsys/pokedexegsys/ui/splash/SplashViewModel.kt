package br.com.egsys.pokedexegsys.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.egsys.pokedexegsys.data.datasource.AppPreference
import br.com.egsys.pokedexegsys.data.model.network.PokedexEntries
import br.com.egsys.pokedexegsys.data.model.network.PokemonEntry
import br.com.egsys.pokedexegsys.data.repositories.PokedexRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repository: PokedexRepository,
    private val preferences: AppPreference
) : ViewModel() {

    private val _hasOfflinePokedex = MutableLiveData<Boolean>()
    val hasOfflinePokedex: LiveData<Boolean> = _hasOfflinePokedex

    private val _pokedexEntries = MutableLiveData<PokedexEntriesState>()
    val pokedexEntries: LiveData<PokedexEntriesState> = _pokedexEntries

    private val _databaseInsertion = MutableLiveData<DatabaseInsertionState>()
    val databaseInsertion: LiveData<DatabaseInsertionState> = _databaseInsertion

    private var _totalEntries = 0
    val totalEntries get() = _totalEntries

    fun commitEntries() = preferences.setEntryQuantity(_totalEntries)

    fun fetchPokedexEntries() = viewModelScope.launch(Dispatchers.IO) {
        repository.fetchEntriesFromApi().onStart {
            _pokedexEntries.postValue(PokedexEntriesState.Loading)
        }.catch {
            _pokedexEntries.postValue(PokedexEntriesState.Error(it))
        }.collect {
            _totalEntries = it.pokemon_entries.size
            _pokedexEntries.postValue(PokedexEntriesState.Success(it))
        }
    }

    fun insertOnDatabase(pokemonEntries: List<PokemonEntry>) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        repository.insertOnDatabase(pokemonEntries).onStart {
            _databaseInsertion.postValue(DatabaseInsertionState.Loading)
        }.catch {
            _databaseInsertion.postValue(DatabaseInsertionState.Error(it))
        }.collect {
            _databaseInsertion.postValue(DatabaseInsertionState.Success(it))
        }
    }

    fun verifyIfHasOfflineEntries() = viewModelScope.launch(Dispatchers.IO) {
        val quantity = preferences.getEntryQuantity()
        _hasOfflinePokedex.postValue(quantity > 0)
    }

    sealed class PokedexEntriesState {
        object Loading : PokedexEntriesState()
        data class Success(val pokedexEntries: PokedexEntries) : PokedexEntriesState()
        data class Error(val error: Throwable) : PokedexEntriesState()
    }

    sealed class DatabaseInsertionState {
        object Loading : DatabaseInsertionState()
        data class Success(val entryNumber: Int) : DatabaseInsertionState()
        data class Error(val error: Throwable) : DatabaseInsertionState()
    }
}