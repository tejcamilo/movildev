package com.example.movildev.model

data class Citas (
    val fecha: String = "",
    val hora: String = "",
    val tipo: String = "",
    val modalidad: String = "",
    val profesional: String = "",
    val disponible: Boolean = true
)