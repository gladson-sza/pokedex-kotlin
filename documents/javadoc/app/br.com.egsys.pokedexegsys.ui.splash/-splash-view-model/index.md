//[app](../../../index.md)/[br.com.egsys.pokedexegsys.ui.splash](../index.md)/[SplashViewModel](index.md)

# SplashViewModel

[androidJvm]\
class [SplashViewModel](index.md)(repository: [PokedexRepository](../../br.com.egsys.pokedexegsys.data.repositories/-pokedex-repository/index.md), preferences: [AppPreference](../../br.com.egsys.pokedexegsys.data.datasource/-app-preference/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Types

| Name | Summary |
|---|---|
| [DatabaseInsertionState](-database-insertion-state/index.md) | [androidJvm]<br>sealed class [DatabaseInsertionState](-database-insertion-state/index.md) |
| [PokedexEntriesState](-pokedex-entries-state/index.md) | [androidJvm]<br>sealed class [PokedexEntriesState](-pokedex-entries-state/index.md) |

## Functions

| Name | Summary |
|---|---|
| [clear](index.md#-1936886459%2FFunctions%2F-912451524) | [androidJvm]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)<br>fun [clear](index.md#-1936886459%2FFunctions%2F-912451524)() |
| [commitEntries](commit-entries.md) | [androidJvm]<br>fun [commitEntries](commit-entries.md)()<br>Save the number of pokémon entries |
| [fetchPokedexEntries](fetch-pokedex-entries.md) | [androidJvm]<br>fun [fetchPokedexEntries](fetch-pokedex-entries.md)(): Job<br>Fetch generic pokédex entries (entry number only) |
| [getTag](index.md#-215894976%2FFunctions%2F-912451524) | [androidJvm]<br>open fun &lt;[T](index.md#-215894976%2FFunctions%2F-912451524) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getTag](index.md#-215894976%2FFunctions%2F-912451524)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](index.md#-215894976%2FFunctions%2F-912451524) |
| [insertOnDatabase](insert-on-database.md) | [androidJvm]<br>fun [insertOnDatabase](insert-on-database.md)(pokemonEntries: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonEntry](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-entry/index.md)&gt;): Job<br>Fetch async each pokédex entries, then emit that a entrie was fetched, emit one last entry flag that indicates that the entries was persisted in sqlite |
| [onCleared](index.md#-1930136507%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onCleared](index.md#-1930136507%2FFunctions%2F-912451524)() |
| [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F-912451524) | [androidJvm]<br>open fun &lt;[T](index.md#-1567230750%2FFunctions%2F-912451524) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F-912451524)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](index.md#-1567230750%2FFunctions%2F-912451524)): [T](index.md#-1567230750%2FFunctions%2F-912451524) |
| [verifyIfHasOfflineEntries](verify-if-has-offline-entries.md) | [androidJvm]<br>fun [verifyIfHasOfflineEntries](verify-if-has-offline-entries.md)(): Job |

## Properties

| Name | Summary |
|---|---|
| [databaseInsertion](database-insertion.md) | [androidJvm]<br>val [databaseInsertion](database-insertion.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[SplashViewModel.DatabaseInsertionState](-database-insertion-state/index.md)&gt; |
| [hasOfflinePokedex](has-offline-pokedex.md) | [androidJvm]<br>val [hasOfflinePokedex](has-offline-pokedex.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt; |
| [pokedexEntries](pokedex-entries.md) | [androidJvm]<br>val [pokedexEntries](pokedex-entries.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[SplashViewModel.PokedexEntriesState](-pokedex-entries-state/index.md)&gt; |
| [totalEntries](total-entries.md) | [androidJvm]<br>val [totalEntries](total-entries.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
