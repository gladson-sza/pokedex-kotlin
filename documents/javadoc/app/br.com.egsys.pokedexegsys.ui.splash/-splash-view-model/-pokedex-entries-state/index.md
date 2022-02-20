//[app](../../../../index.md)/[br.com.egsys.pokedexegsys.ui.splash](../../index.md)/[SplashViewModel](../index.md)/[PokedexEntriesState](index.md)

# PokedexEntriesState

[androidJvm]\
sealed class [PokedexEntriesState](index.md)

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>data class [Error](-error/index.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) : [SplashViewModel.PokedexEntriesState](index.md) |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [SplashViewModel.PokedexEntriesState](index.md) |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)(pokedexEntries: [PokedexEntries](../../../br.com.egsys.pokedexegsys.data.model.network/-pokedex-entries/index.md)) : [SplashViewModel.PokedexEntriesState](index.md) |

## Inheritors

| Name |
|---|
| [Loading](-loading/index.md) |
| [Success](-success/index.md) |
| [Error](-error/index.md) |
