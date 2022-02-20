//[app](../../../../index.md)/[br.com.egsys.pokedexegsys.ui.splash](../../index.md)/[SplashViewModel](../index.md)/[DatabaseInsertionState](index.md)

# DatabaseInsertionState

[androidJvm]\
sealed class [DatabaseInsertionState](index.md)

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>data class [Error](-error/index.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) : [SplashViewModel.DatabaseInsertionState](index.md) |
| [Loading](-loading/index.md) | [androidJvm]<br>object [Loading](-loading/index.md) : [SplashViewModel.DatabaseInsertionState](index.md) |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)(entryNumber: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [SplashViewModel.DatabaseInsertionState](index.md) |

## Inheritors

| Name |
|---|
| [Loading](-loading/index.md) |
| [Success](-success/index.md) |
| [Error](-error/index.md) |
