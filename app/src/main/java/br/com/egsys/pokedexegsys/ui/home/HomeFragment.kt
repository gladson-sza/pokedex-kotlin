package br.com.egsys.pokedexegsys.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.egsys.pokedexegsys.databinding.FragmentHomeBinding
import br.com.egsys.pokedexegsys.ui.adapters.PokemonAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val pokemonCardAdapter by lazy { PokemonAdapter {
        val action = HomeFragmentDirections.actionNavigationHomeToDetailsFragment(it.id)
        findNavController().navigate(action)
    }}
    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val window = activity?.window
        window?.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = 0

        binding.rvPokemonCard.adapter = pokemonCardAdapter

        viewModel.pokemonData.observe(viewLifecycleOwner) { state ->
            when(state) {
                is HomeViewModel.PokemonDataState.Error -> {}
                is HomeViewModel.PokemonDataState.Loading -> {}
                is HomeViewModel.PokemonDataState.Success -> {
                    pokemonCardAdapter.submitList(state.pokemonList)
                }
            }

        }

        viewModel.loadPokemonData()

        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}