package br.com.egsys.pokedexegsys.util

import android.graphics.Color
import br.com.egsys.pokedexegsys.data.model.TypeColor

object Util {
    fun getPokemonImageUrl(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }

    fun stringTypeToColor(type: String) = Color.parseColor(TypeColor.valueOf(type.uppercase()).color)
}