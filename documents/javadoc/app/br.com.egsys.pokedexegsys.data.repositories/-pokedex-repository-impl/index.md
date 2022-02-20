//[app](../../../index.md)/[br.com.egsys.pokedexegsys.data.repositories](../index.md)/[PokedexRepositoryImpl](index.md)

# PokedexRepositoryImpl

[androidJvm]\
class [PokedexRepositoryImpl](index.md)(pokemonDao: [PokemonDao](../../br.com.egsys.pokedexegsys.data.datasource.dao/-pokemon-dao/index.md), abilityDao: [AbilityDao](../../br.com.egsys.pokedexegsys.data.datasource.dao/-ability-dao/index.md), service: [PokedexService](../../br.com.egsys.pokedexegsys.data.datasource.service/-pokedex-service/index.md)) : [PokedexRepository](../-pokedex-repository/index.md)

## Functions

| Name | Summary |
|---|---|
| [fetchEntriesFromApi](fetch-entries-from-api.md) | [androidJvm]<br>open override fun [fetchEntriesFromApi](fetch-entries-from-api.md)(): Flow&lt;[PokedexEntries](../../br.com.egsys.pokedexegsys.data.model.network/-pokedex-entries/index.md)&gt; |
| [getAllPokemon](get-all-pokemon.md) | [androidJvm]<br>open override fun [getAllPokemon](get-all-pokemon.md)(sortMode: [SortMode](../../br.com.egsys.pokedexegsys.data.model/-sort-mode/index.md)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt;&gt;<br>Get all stored pokémon data and sort by a given SortMode |
| [getPokemonData](get-pokemon-data.md) | [androidJvm]<br>open override fun [getPokemonData](get-pokemon-data.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Ability](../../br.com.egsys.pokedexegsys.data.model.storage/-ability/index.md)&gt;&gt;&gt;<br>Get a single pokémon data by id and returns a Pair with Pokemon and a list of his abilities |
| [insertOnDatabase](insert-on-database.md) | [androidJvm]<br>open override fun [insertOnDatabase](insert-on-database.md)(pokemon: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonEntry](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-entry/index.md)&gt;): Flow&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;<br>Fetch a pokémon data by a given pokémon entry list, then exec all requests async emitting the entry counter. |
| [searchPokemon](search-pokemon.md) | [androidJvm]<br>open override fun [searchPokemon](search-pokemon.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sortMode: [SortMode](../../br.com.egsys.pokedexegsys.data.model/-sort-mode/index.md)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt;&gt;<br>Do a search based on a query and a given SortMode |
