package br.com.egsys.pokedexegsys.data.model

import br.com.egsys.pokedexegsys.data.model.PokemonAbility
import br.com.egsys.pokedexegsys.data.model.PokemonSpecie
import br.com.egsys.pokedexegsys.data.model.PokemonStat

data class Pokemon(
    val id: Int,
    val name: String,
    val abilities: List<PokemonAbility>,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>,
    val weight: Int,
    val height: Int,
)
