package com.example.movildev.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movildev.model.Factura
import com.example.movildev.repositories.FacturaRepository

class FacturaViewModel(private val repository: FacturaRepository) : ViewModel() {

    val facturaSeleccionada = MutableLiveData<Factura>()

    fun seleccionarFactura(factura: Factura) {
        facturaSeleccionada.value = factura
    }


    val facturas: LiveData<List<Factura>> = repository.obtenerFacturas()

    fun guardarFactura(factura: Factura, callback: (Boolean) -> Unit) {
        repository.guardarFactura(factura, callback)
    }

    fun eliminarFactura(factura: Factura) {
        repository.eliminarFactura(factura)
    }
}

