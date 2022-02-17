package br.com.egsys.pokedexegsys.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.egsys.pokedexegsys.databinding.FragmentHomeBinding
import br.com.egsys.pokedexegsys.ui.adapters.PokemonAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val pokemonCardAdapter by lazy { PokemonAdapter() }
    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

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