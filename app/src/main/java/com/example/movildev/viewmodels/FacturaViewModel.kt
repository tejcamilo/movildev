package com.example.movildev.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movildev.model.Factura
import com.example.movildev.repositories.FacturaRepository

class FacturaViewModel(private val repository: FacturaRepository) : ViewModel() {

    val facturas: LiveData<List<Factura>> = repository.obtenerFacturas()

    private val _facturaSeleccionada = MutableLiveData<Factura?>()
    val facturaSeleccionada: LiveData<Factura?> get() = _facturaSeleccionada

    fun guardarFactura(factura: Factura, callback: (Boolean) -> Unit) {
        repository.guardarFactura(factura, callback)
    }

    fun eliminarFactura(factura: Factura) {
        repository.eliminarFactura(factura)
    }

    fun seleccionarFactura(factura: Factura) {
        _facturaSeleccionada.value = factura
    }
}