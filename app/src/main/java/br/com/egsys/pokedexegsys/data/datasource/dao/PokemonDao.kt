package br.com.egsys.pokedexegsys.data.datasource.dao

import androidx.room.*
import br.com.egsys.pokedexegsys.data.model.storage.Ability
import br.com.egsys.pokedexegsys.data.model.storage.Pokemon
import br.com.egsys.pokedexegsys.data.model.storage.Stats
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    fun findById(id: Int): Pokemon

    @Query("SELECT * FROM Pokemon WHERE name LIKE :pkmName")
    fun findByName(pkmName: String): List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE name LIKE :query OR id = :query")
    fun findByNameAndId(query: String): List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg pokemon: Pokemon)

    @Query("SELECT * FROM Pokemon ORDER BY id ASC")
    fun findAllSortedByDexNational(): List<Pokemon>

    @Query("SELECT * FROM Pokemon ORDER BY name ASC")
    fun findAllSortedByName(): List<Pokemon>

    @Query("SELECT * FROM Pokemon ORDER BY type1 ASC")
    fun findAllSortedByType(): List<Pokemon>
}