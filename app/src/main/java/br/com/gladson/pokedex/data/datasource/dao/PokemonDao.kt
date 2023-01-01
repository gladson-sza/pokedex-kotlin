package br.com.gladson.pokedex.data.datasource.dao

import androidx.room.*
import br.com.gladson.pokedex.data.model.storage.Pokemon

@Dao
interface PokemonDao {

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    fun findById(id: Int): Pokemon

    @Query("SELECT * FROM Pokemon WHERE name LIKE :pkmName")
    fun findByName(pkmName: String): List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE UPPER(name) LIKE UPPER(:query) || '%' ORDER BY id ASC")
    fun findByNameAndIdDexSort(query: String): List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE UPPER(name) LIKE UPPER(:query) || '%' ORDER BY name ASC")
    fun findByNameAndIdNameSort(query: String): List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE UPPER(name) LIKE UPPER(:query) || '%' ORDER BY type1 ASC")
    fun findByNameAndIdTypeSort(query: String): List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg pokemon: Pokemon)

    @Query("SELECT * FROM Pokemon ORDER BY id ASC")
    fun findAllSortedByDexNational(): List<Pokemon>

    @Query("SELECT * FROM Pokemon ORDER BY name ASC")
    fun findAllSortedByName(): List<Pokemon>

    @Query("SELECT * FROM Pokemon ORDER BY type1 ASC")
    fun findAllSortedByType(): List<Pokemon>
}