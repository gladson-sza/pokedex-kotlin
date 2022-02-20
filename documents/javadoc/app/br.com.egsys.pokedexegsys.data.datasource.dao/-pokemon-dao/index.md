//[app](../../../index.md)/[br.com.egsys.pokedexegsys.data.datasource.dao](../index.md)/[PokemonDao](index.md)

# PokemonDao

[androidJvm]\
interface [PokemonDao](index.md)

## Functions

| Name | Summary |
|---|---|
| [findAllSortedByDexNational](find-all-sorted-by-dex-national.md) | [androidJvm]<br>abstract fun [findAllSortedByDexNational](find-all-sorted-by-dex-national.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt; |
| [findAllSortedByName](find-all-sorted-by-name.md) | [androidJvm]<br>abstract fun [findAllSortedByName](find-all-sorted-by-name.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt; |
| [findAllSortedByType](find-all-sorted-by-type.md) | [androidJvm]<br>abstract fun [findAllSortedByType](find-all-sorted-by-type.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt; |
| [findById](find-by-id.md) | [androidJvm]<br>abstract fun [findById](find-by-id.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md) |
| [findByName](find-by-name.md) | [androidJvm]<br>abstract fun [findByName](find-by-name.md)(pkmName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt; |
| [findByNameAndIdDexSort](find-by-name-and-id-dex-sort.md) | [androidJvm]<br>abstract fun [findByNameAndIdDexSort](find-by-name-and-id-dex-sort.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt; |
| [findByNameAndIdNameSort](find-by-name-and-id-name-sort.md) | [androidJvm]<br>abstract fun [findByNameAndIdNameSort](find-by-name-and-id-name-sort.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt; |
| [findByNameAndIdTypeSort](find-by-name-and-id-type-sort.md) | [androidJvm]<br>abstract fun [findByNameAndIdTypeSort](find-by-name-and-id-type-sort.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt; |
| [insertAll](insert-all.md) | [androidJvm]<br>abstract fun [insertAll](insert-all.md)(vararg pokemon: [Pokemon](../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)) |
