package com.example.movildev.model

data class Usuario(
    val id: Int,
    val nombre: String,
    val tipoDocumento: String,
    val documento: String,
    val fechaNacimiento: String,
    val email: String,
    val nombrePersona: String,
    val telefono: String
)
