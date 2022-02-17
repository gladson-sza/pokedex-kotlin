package br.com.egsys.pokedexegsys.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.egsys.pokedexegsys.data.model.Pokemon
import br.com.egsys.pokedexegsys.data.model.TypeColor
import br.com.egsys.pokedexegsys.databinding.ItemPokemonCardBinding
import br.com.egsys.pokedexegsys.util.Util
import br.com.egsys.pokedexegsys.util.setBackgroundTintColor
import com.bumptech.glide.Glide

class PokemonAdapter(
    private val onCardClickListener: (movie: Pokemon) -> Unit = {}
) : ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemPokemonCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pokemon) {
            val type1 = item.types[0].type
            binding.tvType1.text = type1.name.replaceFirstChar { it.uppercase() }

            if (item.types.size > 1) {
                val type2 = item.types[1].type

                binding.tvType2.visibility = View.VISIBLE
                binding.tvType2.text = type2.name
                binding.tvType2.text = type2.name.replaceFirstChar { it.uppercase() }
            }

            Glide.with(binding.root.context)
                .load(Util.getPokemonImageUrl(item.id))
                .into(binding.ivPokemon)

            binding.card.setBackgroundTintColor(TypeColor.valueOf(type1.name.uppercase()).color)
            binding.card.setOnClickListener { onCardClickListener.invoke(item) }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem == newItem
        override fun areContentsTheSame(
            oldItem: Pokemon,
            newItem: Pokemon
        ) = oldItem.id == newItem.id
    }
}