package br.com.egsys.pokedexegsys.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.egsys.pokedexegsys.data.model.SortMode
import br.com.egsys.pokedexegsys.databinding.FragmentHomeBinding
import br.com.egsys.pokedexegsys.ui.adapters.PokemonAdapter
import br.com.egsys.pokedexegsys.util.hideSoftKeyboard
import br.com.egsys.pokedexegsys.util.setStatusBarColor
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<HomeViewModel>()

    private var minId: Int? = null
    private var maxId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setStatusBarColor(Color.TRANSPARENT)

        binding.chipGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.chipDexNumber.id -> viewModel.setSortMode(SortMode.DEX)
                binding.chipAlphabetic.id -> viewModel.setSortMode(SortMode.ALPHABETIC)
                binding.chiType.id -> viewModel.setSortMode(SortMode.TYPE)
            }

            viewModel.loadPokemonData()
        }

        binding.svSearchPokemon.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.root.hideSoftKeyboard()
                query?.let { viewModel.search(it) }
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let { viewModel.search(it) }
                return false
            }
        })

        binding.fabRandomPokemon.setOnClickListener {
            if (minId != null && maxId != null) {
                val randomId = Random.nextInt(minId!!, maxId!!)
                val action = HomeFragmentDirections.actionNavigationHomeToDetailsFragment(randomId)
                findNavController().navigate(action)
            } else {
                Toast.makeText(
                    requireContext(),
                    "No data was loaded on pokédex",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        viewModel.pokemonData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeViewModel.PokemonDataState.Error -> {}
                is HomeViewModel.PokemonDataState.Loading -> {}
                is HomeViewModel.PokemonDataState.Success -> {
                    val adapter = PokemonAdapter {
                        val action = HomeFragmentDirections.actionNavigationHomeToDetailsFragment(
                            it.id
                        )
                        findNavController().navigate(action)
                    }

                    binding.rvPokemonCard.adapter = null
                    binding.rvPokemonCard.adapter = adapter
                    adapter.submitList(state.pokemonList)

                    if (state.pokemonList.isNotEmpty()) {
                        minId = state.pokemonList.first().id
                        maxId = state.pokemonList.last().id + 1
                    }
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