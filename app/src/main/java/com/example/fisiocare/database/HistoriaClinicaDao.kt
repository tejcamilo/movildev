package com.example.fisiocare.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.fisiocare.Model.HistoriaClinica

@Dao
interface HistoriaClinicaDao {

    @Insert
    suspend fun insertar(historia: HistoriaClinica)

    // Otros métodos...
}
