//[app](../../../../index.md)/[br.com.egsys.pokedexegsys.ui.details](../../index.md)/[DetailsViewModel](../index.md)/[PokemonDataState](index.md)

# PokemonDataState

[androidJvm]\
sealed class [PokemonDataState](index.md)

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>data class [Error](-error/index.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) : [DetailsViewModel.PokemonDataState](index.md) |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [DetailsViewModel.PokemonDataState](index.md) |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)(pokemonData: [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Pokemon](../../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Ability](../../../br.com.egsys.pokedexegsys.data.model.storage/-ability/index.md)&gt;&gt;) : [DetailsViewModel.PokemonDataState](index.md) |

## Inheritors

| Name |
|---|
| [Loading](-loading/index.md) |
| [Success](-success/index.md) |
| [Error](-error/index.md) |
