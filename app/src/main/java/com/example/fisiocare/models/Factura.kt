package com.example.fisiocare.models

data class Factura(
    val id: String,
    val cliente: String,
    val tratamiento: String,
    val valor: Double
)
