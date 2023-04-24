package eu.tutorials.room

import androidx.room.*

@Dao
interface personDao {
    @Query("SELECT * FROM person")
    suspend fun allPerson():List<personEntity>

    @Insert
    suspend fun addPerson(person:personEntity)

    @Update
    suspend fun updatePerson(person: personEntity)

    @Delete
    suspend fun deletePerson(person:personEntity)

    @Query("SELECT * FROM person ORDER BY RANDOM() LIMIT 1")
    suspend fun randomPerson():List<personEntity>

    @Query("SELECT * FROM person WHERE name like '%'|| :searchWord || '%'")
    suspend fun searchPerson(searchWord:String):List<personEntity>

    @Query("SELECT * FROM person WHERE id=:specified_id")
    suspend fun getPerson(specified_id:Int):personEntity

    @Query("SELECT count(*) FROM person WHERE name=:name")
    suspend fun getMultiplePerson(name:String):Int
}