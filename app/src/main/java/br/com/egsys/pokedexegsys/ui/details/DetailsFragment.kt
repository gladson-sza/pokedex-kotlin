package br.com.egsys.pokedexegsys.ui.details

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
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

        val pokemonId = args.pokemonId
        viewModel.loadPokemonData(pokemonId)

        viewModel.pokemonData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DetailsViewModel.PokemonDataState.Error -> {}
                is DetailsViewModel.PokemonDataState.Loading -> {}
                is DetailsViewModel.PokemonDataState.Success -> {
                    loadPokemonDetails(
                        state.pokemonData.first,
                        state.pokemonData.second
                    )
                }
            }
        }



        binding.btnBackToHome.setOnClickListener { findNavController().popBackStack() }

        binding.btnBack.setOnClickListener {
            val hyperspaceJump: Animation =
                AnimationUtils.loadAnimation(requireContext(), R.anim.slide_left)
            binding.root.startAnimation(hyperspaceJump)

        }
        binding.btnForward.setOnClickListener {

        }

        return binding.root
    }

    private fun loadPokemonDetails(pokemon: Pokemon, abilities: List<Ability>) {
        val mainColor = Util.stringTypeToColor(pokemon.type1)

        val window = activity?.window
        window?.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = mainColor

        Glide.with(requireContext())
            .load(Util.getPokemonImageUrl(pokemon.id))
            .into(binding.ivPokemon)

        binding.root.setBackgroundColor(mainColor)
        binding.tvTitle.text = pokemon.name.replaceFirstChar { it.uppercase() }
        binding.tvDexNumber.text = "#${pokemon.id.toString().padStart(3, '0')}"
        binding.tvType1.text = pokemon.type1.replaceFirstChar { it.uppercase() }
        binding.tvType1.setBackgroundTintColor(TypeColor.valueOf(pokemon.type1.uppercase()).color)

        pokemon.type2?.let {
            binding.tvType2.visibility = View.VISIBLE
            binding.tvType2.text = it.replaceFirstChar { c -> c.uppercase() }
            binding.tvType2.setBackgroundTintColor(TypeColor.valueOf(it.uppercase()).color)
        }


        binding.tvWeight.text = "${pokemon.weight / 10.0} Kg"
        binding.tvHeight.text = "${(pokemon.height / 10.0)} m"

        binding.tvDescription.text = pokemon.description.replace("\n", " ");

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