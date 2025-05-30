package com.example.fisiocare.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historias_clinicas")
data class HistoriaClinicaEntity(
    @PrimaryKey val id: String,
    val nombre: String,
    val fecha: String,
    val diagnostico: String,
    val tratamiento: String,
    val notas: String
)
