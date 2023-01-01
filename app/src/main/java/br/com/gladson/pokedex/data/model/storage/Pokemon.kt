package br.com.gladson.pokedex.data.model.storage

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(
    @PrimaryKey var id: Int,
    var name: String,
    var weight: Int,
    var height: Int,
    var description: String,
    var type1: String,
    var type2: String?,
    @Embedded val stats: Stats,
)
