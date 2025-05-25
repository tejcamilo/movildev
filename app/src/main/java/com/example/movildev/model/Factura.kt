package com.example.movildev.model

data class Factura(
    val id: String = "",
    val fecha: String = "",
    val hora: String = "",
    val paciente: String,
    val tratamiento: String,
    val valor: Double,
    val documento: String = "",
    val telefono: String = "",
    val correo: String = "",
    val razonSocial: String = "",
    val nit: String = ""
)






