package com.example.fisiocare.repositories



import com.example.fisiocare.models.Factura

class FacturaRepository {
    fun guardarFactura(factura: Factura) {
        // Simula guardar una factura en una base de datos
        println("Factura guardada: $factura")
    }
}
