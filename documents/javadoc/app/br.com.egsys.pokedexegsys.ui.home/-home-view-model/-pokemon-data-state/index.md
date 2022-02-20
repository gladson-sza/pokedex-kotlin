//[app](../../../../index.md)/[br.com.egsys.pokedexegsys.ui.home](../../index.md)/[HomeViewModel](../index.md)/[PokemonDataState](index.md)

# PokemonDataState

[androidJvm]\
sealed class [PokemonDataState](index.md)

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>data class [Error](-error/index.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) : [HomeViewModel.PokemonDataState](index.md) |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [HomeViewModel.PokemonDataState](index.md) |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)(pokemonList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pokemon](../../../br.com.egsys.pokedexegsys.data.model.storage/-pokemon/index.md)&gt;) : [HomeViewModel.PokemonDataState](index.md) |

## Inheritors

| Name |
|---|
| [Loading](-loading/index.md) |
| [Success](-success/index.md) |
| [Error](-error/index.md) |
