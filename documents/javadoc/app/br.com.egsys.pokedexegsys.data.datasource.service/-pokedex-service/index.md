//[app](../../../index.md)/[br.com.egsys.pokedexegsys.data.datasource.service](../index.md)/[PokedexService](index.md)

# PokedexService

[androidJvm]\
interface [PokedexService](index.md)

## Functions

| Name | Summary |
|---|---|
| [fetchNationalDex](fetch-national-dex.md) | [androidJvm]<br>@GET(value = "pokedex/1")<br>abstract suspend fun [fetchNationalDex](fetch-national-dex.md)(): [PokedexEntries](../../br.com.egsys.pokedexegsys.data.model.network/-pokedex-entries/index.md)<br>1 -> National dex ID |
| [fetchPokemonById](fetch-pokemon-by-id.md) | [androidJvm]<br>@GET(value = "pokemon/{id}")<br>abstract suspend fun [fetchPokemonById](fetch-pokemon-by-id.md)(@Path(value = "id")id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [PokemonDex](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-dex/index.md) |
| [fetchPokemonSpecieById](fetch-pokemon-specie-by-id.md) | [androidJvm]<br>@GET(value = "pokemon-species/{id}")<br>abstract suspend fun [fetchPokemonSpecieById](fetch-pokemon-specie-by-id.md)(@Path(value = "id")id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [PokemonSpecie](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-specie/index.md)<br>This route is to get pokedex text entries |
