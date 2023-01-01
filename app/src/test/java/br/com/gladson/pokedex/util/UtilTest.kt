package br.com.gladson.pokedex.util

import org.junit.Assert.*
import org.junit.Test

class UtilTest {

    @Test
    fun `get correct url from pokemon id`() {
        val url = Util.getPokemonImageUrl(1)

        assertEquals(
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            url
        )
    }
}