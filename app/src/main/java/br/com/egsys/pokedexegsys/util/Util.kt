package br.com.egsys.pokedexegsys.util

import android.graphics.Color
import br.com.egsys.pokedexegsys.data.model.TypeColor

object Util {

    /**
     * Get pokémon image URL by a given id
     * Evey pokémon image has the same url, only changes the id
     *
     * @param id: pokémon entry
     */
    fun getPokemonImageUrl(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }

    /**
     * Parse a Hex color to a int color
     */
    fun stringTypeToColor(type: String) = Color.parseColor(TypeColor.valueOf(type.uppercase()).color)
}