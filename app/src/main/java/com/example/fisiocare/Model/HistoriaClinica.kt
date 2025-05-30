package com.example.fisiocare.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historias_clinicas")
data class HistoriaClinica(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombreCompleto: String,
    val documento: String,
    val telefono: String,
    val eps: String,
    val motivoConsulta: String,
)
