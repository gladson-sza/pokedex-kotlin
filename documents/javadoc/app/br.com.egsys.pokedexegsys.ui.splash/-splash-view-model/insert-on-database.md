//[app](../../../index.md)/[br.com.egsys.pokedexegsys.ui.splash](../index.md)/[SplashViewModel](index.md)/[insertOnDatabase](insert-on-database.md)

# insertOnDatabase

[androidJvm]\
fun [insertOnDatabase](insert-on-database.md)(pokemonEntries: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonEntry](../../br.com.egsys.pokedexegsys.data.model.network/-pokemon-entry/index.md)&gt;): Job

Fetch async each pokédex entries, then emit that a entrie was fetched, emit one last entry flag that indicates that the entries was persisted in sqlite
