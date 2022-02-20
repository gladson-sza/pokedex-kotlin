//[app](../../../index.md)/[br.com.egsys.pokedexegsys.data.repositories](../index.md)/[PokedexRepository](index.md)

# PokedexRepository

[androidJvm]\
interface [PokedexRepository](index.md)

## Functions

| Name | Summary |
|---|---|
| [fetchEntriesFromApi](fetch-entries-from-api.md) | [androidJvm]<br>abstract fun [fetchEntriesFromApi](fetch-entries-from-api.md)(): Flow&lt;[PokedexEntries](../../br.com.egsys.pokedexegsys.data.model.network/-pokedex-entries/index.md)&gt; |
| [getAllPokemon](get-all-pokemon.md) | [androidJvm]<br>abstract fun [getAllPokemon](get-all-pokemon.md)(sortMode: [SortMode](../../br.com.egsys.pokedexegsys.data.model/-sort-mode/index.md)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt;&gt; |
| [getPokemonData](get-pokemon-data.md) | [androidJvm]<br>abstract fun [getPokemonData](get-pokemon-data.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Ability](../../br.com.egsys.pokedexegsys.data.model.storage/-ability/index.md)&gt;&gt;&gt; |
| [insertOnDatabase](insert-on-database.md) | [androidJvm]<br>abstract fun [insertOnDatabase](insert-on-database.md)(pokemon: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonEntry](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-entry/index.md)&gt;): Flow&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt; |
| [searchPokemon](search-pokemon.md) | [androidJvm]<br>abstract fun [searchPokemon](search-pokemon.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sortMode: [SortMode](../../br.com.egsys.pokedexegsys.data.model/-sort-mode/index.md)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt;&gt; |

## Inheritors

| Name |
|---|
| [PokedexRepositoryImpl](../-pokedex-repository-impl/index.md) |
