package com.example.fisiocare.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historia_clinica")
data class HistoriaClinica(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombreCompleto: String,
    val documento: String,
    val telefono: String,
    val correo: String,
    val eps: String,
    val antecedentes: String
    // Agrega diagnóstico y tratamiento si los necesitas luego
)
