//[app](../../../index.md)/[br.com.egsys.pokedexegsys.ui.home](../index.md)/[HomeViewModel](index.md)

# HomeViewModel

[androidJvm]\
class [HomeViewModel](index.md)(repository: [PokedexRepository](../../br.com.egsys.pokedexegsys.data.repositories/-pokedex-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Types

| Name | Summary |
|---|---|
| [PokemonDataState](-pokemon-data-state/index.md) | [androidJvm]<br>sealed class [PokemonDataState](-pokemon-data-state/index.md) |

## Functions

| Name | Summary |
|---|---|
| [clear](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1936886459%2FFunctions%2F-912451524) | [androidJvm]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)<br>fun [clear](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1936886459%2FFunctions%2F-912451524)() |
| [getTag](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-215894976%2FFunctions%2F-912451524) | [androidJvm]<br>open fun &lt;[T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-215894976%2FFunctions%2F-912451524) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getTag](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-215894976%2FFunctions%2F-912451524)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-215894976%2FFunctions%2F-912451524) |
| [loadPokemonData](load-pokemon-data.md) | [androidJvm]<br>fun [loadPokemonData](load-pokemon-data.md)(): Job<br>Load pokémon data based on current sort mode If Sort mode was not changed, the default sort mode will be DEX |
| [onCleared](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1930136507%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onCleared](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1930136507%2FFunctions%2F-912451524)() |
| [search](search.md) | [androidJvm]<br>fun [search](search.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Job<br>Do a search based on pokémon name |
| [setSortMode](set-sort-mode.md) | [androidJvm]<br>fun [setSortMode](set-sort-mode.md)(sortType: [SortMode](../../br.com.egsys.pokedexegsys.data.model/-sort-mode/index.md))<br>Changes the state of sort mode variable |
| [setTagIfAbsent](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524) | [androidJvm]<br>open fun &lt;[T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [setTagIfAbsent](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524)): [T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524) |

## Properties

| Name | Summary |
|---|---|
| [pokemonData](pokemon-data.md) | [androidJvm]<br>val [pokemonData](pokemon-data.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[HomeViewModel.PokemonDataState](-pokemon-data-state/index.md)&gt; |
