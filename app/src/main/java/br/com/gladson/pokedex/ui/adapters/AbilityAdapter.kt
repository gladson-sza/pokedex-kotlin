package br.com.gladson.pokedex.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.com.gladson.pokedex.data.model.storage.Ability
import br.com.gladson.pokedex.databinding.ItemAbilityBinding

class AbilityAdapter(
    context: Context,
    private val abilities: List<Ability>
) : ArrayAdapter<Ability>(
    context, 0, abilities
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)

        if (convertView == null) {
            val textView = ItemAbilityBinding.inflate(inflater, parent, false)
            textView.root.text = abilities[position].name.replaceFirstChar { it.uppercase() }
            return textView.root
        }

        return convertView
    }
}