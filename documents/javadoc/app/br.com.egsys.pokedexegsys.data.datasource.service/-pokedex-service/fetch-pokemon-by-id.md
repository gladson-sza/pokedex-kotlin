//[app](../../../index.md)/[br.com.egsys.pokedexegsys.data.datasource.service](../index.md)/[PokedexService](index.md)/[fetchPokemonById](fetch-pokemon-by-id.md)

# fetchPokemonById

[androidJvm]\

@GET(value = "pokemon/{id}")

abstract suspend fun [fetchPokemonById](fetch-pokemon-by-id.md)(@Path(value = "id")id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [PokemonDex](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-dex/index.md)
