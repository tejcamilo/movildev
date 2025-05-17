package com.example.movildev.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CitaDao {
    @Insert
     fun insert(cita: Cita)

    @Update
     fun update(cita: Cita)

    @Delete
     fun delete(cita: Cita)

    // methods below use liveData so they don't need a coroutine
    @Query("SELECT * FROM cita_table WHERE citaId = :citaId")
    fun get(citaId : Long) : LiveData<Cita>

    @Query("SELECT * FROM cita_table ORDER BY citaId DESC")
    fun getAll() : LiveData<List<Cita>>
}