package com.example.movildev.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facturas")
data class Factura(
    @PrimaryKey val id: String,
    val fecha: String = "",
    val hora: String = "",
    val paciente: String,
    val tratamiento: String,
    val valor: Double
)



