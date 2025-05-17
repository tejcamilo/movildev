package com.example.movildev.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cita_table")
data class Cita (
    @PrimaryKey(autoGenerate = true)
    var citaId: Long = 0L,
    @ColumnInfo(name = "cita_fecha")
    var fecha: String = "",
    @ColumnInfo(name = "cita_hora")
    var hora: String = "",
    @ColumnInfo(name = "cita_tipo")
    var tipo: String = "",
    @ColumnInfo(name = "cita_modalidad")
    var modalidad: String = "",
    @ColumnInfo(name = "cita_profesional")
    var profesional: String = "",
    @ColumnInfo(name = "cita_disponible")
    var disponible: Boolean = true
)