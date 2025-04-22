package com.example.fisiocare.viewmodels


import androidx.lifecycle.ViewModel
import com.example.fisiocare.models.Factura
import com.example.fisiocare.repositories.FacturaRepository

class CrearFacturaViewModel(
    private val repository: FacturaRepository
) : ViewModel() {

    fun guardarFactura(cliente: String, tratamiento: String, valor: Double) {
        val factura = Factura(
            id = System.currentTimeMillis().toString(),
            cliente = cliente,
            tratamiento = tratamiento,
            valor = valor
        )
        repository.guardarFactura(factura)
    }
}
