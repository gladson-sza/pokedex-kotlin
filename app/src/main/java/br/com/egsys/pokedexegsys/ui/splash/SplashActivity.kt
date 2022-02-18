package br.com.egsys.pokedexegsys.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.egsys.pokedexegsys.databinding.ActivitySplashBinding
import br.com.egsys.pokedexegsys.ui.MainActivity
import br.com.egsys.pokedexegsys.util.setFullScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setFullScreen(binding.root)

        binding.tvTouch.setOnClickListener { viewModel.verifyIfHasOfflineEntries() }

        viewModel.hasOfflinePokedex.observe(this) { hasOfflineEntries ->
            if (hasOfflineEntries) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                viewModel.fetchPokedexEntries()
            }
        }

        viewModel.pokedexEntries.observe(this) { state ->
            when (state) {
                is SplashViewModel.PokedexEntriesState.Error -> {
                    Log.e("pokedexEntries", state.error.message.toString())
                }
                is SplashViewModel.PokedexEntriesState.Loading -> {}
                is SplashViewModel.PokedexEntriesState.Success -> {
                    viewModel.insertOnDatabase(state.pokedexEntries.pokemon_entries)
                }
            }
        }

        viewModel.databaseInsertion.observe(this) { state ->
            when(state) {
                is SplashViewModel.DatabaseInsertionState.Error -> {
                    Log.e("databaseInsertion", state.error.message.toString())
                }
                is SplashViewModel.DatabaseInsertionState.Loading -> {}
                is SplashViewModel.DatabaseInsertionState.Success -> {
                    viewModel.verifyIfHasOfflineEntries()
                }
            }
        }
    }
}
