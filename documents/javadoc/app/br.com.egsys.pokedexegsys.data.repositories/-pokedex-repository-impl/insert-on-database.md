//[app](../../../index.md)/[br.com.egsys.pokedexegsys.data.repositories](../index.md)/[PokedexRepositoryImpl](index.md)/[insertOnDatabase](insert-on-database.md)

# insertOnDatabase

[androidJvm]\
open override fun [insertOnDatabase](insert-on-database.md)(pokemon: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonEntry](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-entry/index.md)&gt;): Flow&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;

Fetch a pokémon data by a given pokémon entry list, then exec all requests async emitting the entry counter.

After wait all the results, the pokémon data is peristed locally then is emitted one last counter that indicates that the data was persisted
