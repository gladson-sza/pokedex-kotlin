package br.com.egsys.pokedexegsys.data.model.network

data class PokemonDex(
    val abilities: List<PokemonAbility>,
    val height: Int, // Decimetres
    val weight: Int, // Hectograms
    val name: String,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>
)