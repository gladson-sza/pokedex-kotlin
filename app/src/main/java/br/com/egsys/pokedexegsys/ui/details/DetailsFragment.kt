package br.com.egsys.pokedexegsys.ui.details

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.egsys.pokedexegsys.R
import br.com.egsys.pokedexegsys.data.model.TypeColor
import br.com.egsys.pokedexegsys.data.model.storage.Ability
import br.com.egsys.pokedexegsys.data.model.storage.Pokemon
import br.com.egsys.pokedexegsys.databinding.FragmentDetailsBinding
import br.com.egsys.pokedexegsys.ui.adapters.AbilityAdapter
import br.com.egsys.pokedexegsys.util.Util
import br.com.egsys.pokedexegsys.util.setBackgroundTintColor
import br.com.egsys.pokedexegsys.util.setIsVisible
import br.com.egsys.pokedexegsys.util.setStatusBarColor
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<DetailsViewModel>()

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        viewModel.loadPokemonData(args.pokemonId)

        viewModel.pokemonData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DetailsViewModel.PokemonDataState.Error -> {}
                is DetailsViewModel.PokemonDataState.Loading -> {}
                is DetailsViewModel.PokemonDataState.Success -> {
                    binding.btnBack.setIsVisible(viewModel.currentPokemonId > viewModel.minPokemonId)
                    binding.btnForward.setIsVisible(viewModel.currentPokemonId < viewModel.maxPokemonId)

                    loadPokemonDetails(
                        state.pokemonData.first,
                        state.pokemonData.second
                    )
                }
            }
        }

        binding.btnBackToHome.setOnClickListener { findNavController().popBackStack() }

        binding.btnBack.setOnClickListener {
            viewModel.loadPreviousPokemon()
        }
        binding.btnForward.setOnClickListener {
            viewModel.loadNextPokemon()
        }

        return binding.root
    }

    /**
     * Load pokémon details on screen and change background color by 1st type of pokémon
     */
    private fun loadPokemonDetails(pokemon: Pokemon, abilities: List<Ability>) {
        val mainColor = Util.stringTypeToColor(pokemon.type1)
        setStatusBarColor(mainColor)

        Glide.with(requireContext())
            .load(Util.getPokemonImageUrl(pokemon.id))
            .into(binding.ivPokemon)

        binding.root.setBackgroundColor(mainColor)
        binding.tvTitle.text = pokemon.name.replaceFirstChar { it.uppercase() }
        binding.tvDexNumber.text = requireContext().resources.getString(
            R.string.adapter_dex_number,
            pokemon.id.toString().padStart(3, '0')
        )
        binding.tvType1.text = pokemon.type1.replaceFirstChar { it.uppercase() }
        binding.tvType1.setBackgroundTintColor(TypeColor.valueOf(pokemon.type1.uppercase()).color)

        if (pokemon.type2 != null) {
            binding.tvType2.apply {
                setIsVisible(true)
                text = pokemon.type2!!.replaceFirstChar { it.uppercase() }
                setBackgroundTintColor(TypeColor.valueOf(pokemon.type2!!.uppercase()).color)
            }
        } else {
            binding.tvType2.setIsVisible(false)
        }


        binding.tvWeight.text = requireContext().resources.getString(
            R.string.label_kg,
            (pokemon.weight / 10.0).toString()
        )

        binding.tvHeight.text = requireContext().resources.getString(
            R.string.label_m,
            (pokemon.weight / 10.0).toString()
        )

        binding.tvDescription.text = pokemon.description.replace("\n", " ")

        binding.tvHpLabel.setTextColor(mainColor)
        binding.tvAtkLabel.setTextColor(mainColor)
        binding.tvDefLabel.setTextColor(mainColor)
        binding.tvSatkLabel.setTextColor(mainColor)
        binding.tvSdefLabel.setTextColor(mainColor)
        binding.tvSpdLabel.setTextColor(mainColor)

        binding.tvAboutLabel.setTextColor(mainColor)
        binding.tvStatsLabel.setTextColor(mainColor)

        binding.tvHp.text = pokemon.stats.hp.toString().padStart(3, '0')
        binding.tvAtk.text = pokemon.stats.attack.toString().padStart(3, '0')
        binding.tvDef.text = pokemon.stats.defense.toString().padStart(3, '0')
        binding.tvSatk.text = pokemon.stats.spAttack.toString().padStart(3, '0')
        binding.tvSdef.text = pokemon.stats.spDefense.toString().padStart(3, '0')
        binding.tvSpd.text = pokemon.stats.speed.toString().padStart(3, '0')

        binding.pbHp.progress = pokemon.stats.hp!!
        binding.pbAtk.progress = pokemon.stats.attack!!
        binding.pbDef.progress = pokemon.stats.defense!!
        binding.pbSatk.progress = pokemon.stats.spAttack!!
        binding.pbSdef.progress = pokemon.stats.spDefense!!
        binding.pbSpd.progress = pokemon.stats.speed!!

        binding.pbHp.progressTintList = ColorStateList.valueOf(mainColor)
        binding.pbAtk.progressTintList = ColorStateList.valueOf(mainColor)
        binding.pbDef.progressTintList = ColorStateList.valueOf(mainColor)
        binding.pbSatk.progressTintList = ColorStateList.valueOf(mainColor)
        binding.pbSdef.progressTintList = ColorStateList.valueOf(mainColor)
        binding.pbSpd.progressTintList = ColorStateList.valueOf(mainColor)

        binding.lvAbilities.adapter = AbilityAdapter(
            requireContext(),
            abilities
        )
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}