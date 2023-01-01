package br.com.gladson.pokedex.data.model.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ability(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    var pokemonId: Int,
    var name: String
)