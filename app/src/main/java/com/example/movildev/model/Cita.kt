package com.example.movildev.model

data class Cita (
    val id: String = "",
    val fecha: String = "",
    val hora: String = "",
    val tipo: String = "",
    val modalidad: String = "",
    val profesional: String = "",
    var disponible: Boolean = true
)