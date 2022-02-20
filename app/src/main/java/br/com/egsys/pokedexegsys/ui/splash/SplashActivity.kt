package br.com.egsys.pokedexegsys.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.egsys.pokedexegsys.R
import br.com.egsys.pokedexegsys.databinding.ActivitySplashBinding
import br.com.egsys.pokedexegsys.ui.MainActivity
import br.com.egsys.pokedexegsys.util.setFullScreen
import br.com.egsys.pokedexegsys.util.setIsVisible
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
                openAnimation()
            } else {
                viewModel.fetchPokedexEntries()
            }
        }

        viewModel.pokedexEntries.observe(this) { state ->
            when (state) {
                is SplashViewModel.PokedexEntriesState.Loading -> loadingDataAnimation(
                    resources.getString(
                        R.string.label_fetching_entries
                    )
                )
                is SplashViewModel.PokedexEntriesState.Error -> errorGettingDataAnimation(
                    resources.getString(
                        R.string.error_fetching_entries
                    )
                )
                is SplashViewModel.PokedexEntriesState.Success -> viewModel.insertOnDatabase(state.pokedexEntries.pokemon_entries)
            }
        }

        viewModel.databaseInsertion.observe(this) { state ->
            when (state) {
                is SplashViewModel.DatabaseInsertionState.Loading -> loadingDataAnimation(
                    resources.getString(
                        R.string.label_loading_data
                    )
                )
                is SplashViewModel.DatabaseInsertionState.Error -> errorGettingDataAnimation(
                    resources.getString(R.string.error_getting_data)
                )
                is SplashViewModel.DatabaseInsertionState.Success -> {
                    when {
                        state.entryNumber > viewModel.totalEntries -> {
                            viewModel.commitEntries()
                            viewModel.verifyIfHasOfflineEntries()
                        }
                        state.entryNumber == viewModel.totalEntries -> {
                            binding.tvMessage.text = resources.getString(R.string.label_waiting_data)
                        }
                        else -> {
                            binding.tvMessage.text = resources.getString(
                                R.string.label_loading_data_status,
                                state.entryNumber,
                                viewModel.totalEntries
                            )
                        }
                    }
                }
            }
        }
    }

    private fun errorGettingDataAnimation(message: String) {
        binding.pbLoading.setIsVisible(false)
        binding.ivError.setIsVisible(true)
        binding.tvMessage.text = message

        binding.ivError.animate().apply {
            startDelay = 1400
            duration = 200
            withEndAction {
                resetPositionAnimation()
            }.alpha(0f).start()
        }
    }

    private fun loadingDataAnimation(message: String) {
        binding.ivPokedexBottom
            .animate()
            .translationY(200f)
            .duration = 300

        binding.ivPokedexTop
            .animate()
            .translationY(-200F)
            .duration = 300

        binding.tvMessage.text = message

        binding.tvTouch.animate()
            .alpha(0f)
            .setDuration(300)
            .withEndAction {
                binding.pbLoading.setIsVisible(true)
                binding.tvMessage.setIsVisible(true)
            }
    }

    private fun openAnimation() {
        binding.tvTouch.animate()
            .alpha(0f)
            .setDuration(300)
            .withEndAction {
                binding.pbLoading.setIsVisible(true)

                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }

        binding.ivPokedexBottom
            .animate()
            .translationY(400f)
            .duration = 500

        binding.ivPokedexTop
            .animate()
            .translationY(-400F)
            .duration = 500
    }

    private fun resetPositionAnimation() {
        binding.ivPokedexBottom
            .animate()
            .translationY(0f)
            .duration = 500

        binding.ivPokedexTop
            .animate()
            .translationY(0f)
            .duration = 500

        binding.tvTouch.setIsVisible(true)
        binding.pbLoading.setIsVisible(false)
        binding.ivError.setIsVisible(false)
        binding.tvMessage.setIsVisible(false)
        binding.ivError.alpha = 1f
        binding.tvTouch.animate()
            .alpha(1f)
            .duration = 300
    }

    override fun onRestart() {
        resetPositionAnimation()
        super.onRestart()
    }
}
