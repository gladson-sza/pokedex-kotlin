package br.com.egsys.pokedexegsys.data.model

/**
 * Used to get correct value of Stat from network api
 */
enum class StatName(val value: String) {
    HP("hp"),
    ATTACK("attack"),
    DEFENSE("defense"),
    SPECIAL_ATTACK("special-attack"),
    SPECIAL_DEFENSE("special-defense"),
    SPEED("speed")
}