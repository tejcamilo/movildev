package com.example.movildev.model

data class Cita (
    val id: String = "",
    val fecha: String = "",
    val hora: String = "",
    val tratamiento: String = "",
    val paciente: String = "",
    val modalidad: String = "",
    val profesional: String = "Cathalina Cañon",
    var disponible: Boolean = true
)