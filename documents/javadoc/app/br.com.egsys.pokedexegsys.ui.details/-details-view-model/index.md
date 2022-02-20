//[app](../../../index.md)/[br.com.egsys.pokedexegsys.ui.details](../index.md)/[DetailsViewModel](index.md)

# DetailsViewModel

[androidJvm]\
class [DetailsViewModel](index.md)(repository: [PokedexRepository](../../br.com.egsys.pokedexegsys.data.repositories/-pokedex-repository/index.md), preferences: [AppPreference](../../br.com.egsys.pokedexegsys.data.datasource/-app-preference/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Types

| Name | Summary |
|---|---|
| [PokemonDataState](-pokemon-data-state/index.md) | [androidJvm]<br>sealed class [PokemonDataState](-pokemon-data-state/index.md) |

## Functions

| Name | Summary |
|---|---|
| [clear](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1936886459%2FFunctions%2F-912451524) | [androidJvm]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)<br>fun [clear](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1936886459%2FFunctions%2F-912451524)() |
| [getTag](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-215894976%2FFunctions%2F-912451524) | [androidJvm]<br>open fun &lt;[T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-215894976%2FFunctions%2F-912451524) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getTag](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-215894976%2FFunctions%2F-912451524)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-215894976%2FFunctions%2F-912451524) |
| [loadNextPokemon](load-next-pokemon.md) | [androidJvm]<br>fun [loadNextPokemon](load-next-pokemon.md)() |
| [loadPokemonData](load-pokemon-data.md) | [androidJvm]<br>fun [loadPokemonData](load-pokemon-data.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Job |
| [loadPreviousPokemon](load-previous-pokemon.md) | [androidJvm]<br>fun [loadPreviousPokemon](load-previous-pokemon.md)() |
| [onCleared](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1930136507%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [onCleared](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1930136507%2FFunctions%2F-912451524)() |
| [setTagIfAbsent](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524) | [androidJvm]<br>open fun &lt;[T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [setTagIfAbsent](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524)): [T](../../br.com.egsys.pokedexegsys.ui.splash/-splash-view-model/index.md#-1567230750%2FFunctions%2F-912451524) |

## Properties

| Name | Summary |
|---|---|
| [currentPokemonId](current-pokemon-id.md) | [androidJvm]<br>val [currentPokemonId](current-pokemon-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [maxPokemonId](max-pokemon-id.md) | [androidJvm]<br>val [maxPokemonId](max-pokemon-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [minPokemonId](min-pokemon-id.md) | [androidJvm]<br>val [minPokemonId](min-pokemon-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1 |
| [pokemonData](pokemon-data.md) | [androidJvm]<br>val [pokemonData](pokemon-data.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[DetailsViewModel.PokemonDataState](-pokemon-data-state/index.md)&gt; |
