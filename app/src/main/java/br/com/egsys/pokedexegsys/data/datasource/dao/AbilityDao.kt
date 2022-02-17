package br.com.egsys.pokedexegsys.data.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.egsys.pokedexegsys.data.model.storage.Ability

@Dao
interface AbilityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg ability: Ability)

    @Query("SELECT * FROM Ability")
    fun findAll(): List<Ability>

    @Query("SELECT * FROM Ability WHERE Ability.pokemonId = :pkmId")
    fun findByPokemon(pkmId: Int): List<Ability>
}