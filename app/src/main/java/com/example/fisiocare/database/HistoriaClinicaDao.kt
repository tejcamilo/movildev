package com.example.fisiocare.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fisiocare.Model.HistoriaClinica

@Dao
interface HistoriaClinicaDao {
    @Insert
    suspend fun insertarHistoria(historia: HistoriaClinica)

    @Query("SELECT * FROM historias_clinicas WHERE id = :id")
    suspend fun obtenerHistoriaPorId(id: Int): HistoriaClinica?
}
