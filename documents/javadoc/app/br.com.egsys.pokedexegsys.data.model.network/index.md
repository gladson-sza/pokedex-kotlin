//[app](../../index.md)/[br.com.egsys.pokedexegsys.data.model.network](index.md)

# Package br.com.egsys.pokedexegsys.data.model.network

## Types

| Name | Summary |
|---|---|
| [FlavorTextEntry](-flavor-text-entry/index.md) | [androidJvm]<br>data class [FlavorTextEntry](-flavor-text-entry/index.md)(flavor_text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [PokedexEntries](-pokedex-entries/index.md) | [androidJvm]<br>data class [PokedexEntries](-pokedex-entries/index.md)(pokemon_entries: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonEntry](-pokemon-entry/index.md)&gt;) |
| [PokedexItem](-pokedex-item/index.md) | [androidJvm]<br>data class [PokedexItem](-pokedex-item/index.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [PokemonAbility](-pokemon-ability/index.md) | [androidJvm]<br>data class [PokemonAbility](-pokemon-ability/index.md)(ability: [PokedexItem](-pokedex-item/index.md), is_hidden: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [PokemonDex](-pokemon-dex/index.md) | [androidJvm]<br>data class [PokemonDex](-pokemon-dex/index.md)(abilities: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonAbility](-pokemon-ability/index.md)&gt;, height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), weight: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), stats: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonStat](-pokemon-stat/index.md)&gt;, types: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[PokemonType](-pokemon-type/index.md)&gt;) |
| [PokemonEntry](-pokemon-entry/index.md) | [androidJvm]<br>data class [PokemonEntry](-pokemon-entry/index.md)(entry_number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [PokemonSpecie](-pokemon-specie/index.md) | [androidJvm]<br>data class [PokemonSpecie](-pokemon-specie/index.md)(flavor_text_entries: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[FlavorTextEntry](-flavor-text-entry/index.md)&gt;) |
| [PokemonStat](-pokemon-stat/index.md) | [androidJvm]<br>data class [PokemonStat](-pokemon-stat/index.md)(base_stat: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), stat: [PokedexItem](-pokedex-item/index.md)) |
| [PokemonType](-pokemon-type/index.md) | [androidJvm]<br>data class [PokemonType](-pokemon-type/index.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), slot: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), type: [PokedexItem](-pokedex-item/index.md)) |
