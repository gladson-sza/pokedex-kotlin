//[app](../../../index.md)/[br.com.egsys.pokedexegsys.data.datasource.service](../index.md)/[PokedexService](index.md)/[fetchPokemonSpecieById](fetch-pokemon-specie-by-id.md)

# fetchPokemonSpecieById

[androidJvm]\

@GET(value = "pokemon-species/{id}")

abstract suspend fun [fetchPokemonSpecieById](fetch-pokemon-specie-by-id.md)(@Path(value = "id")id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [PokemonSpecie](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-specie/index.md)

This route is to get pokedex text entries
