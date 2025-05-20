package com.example.movildev.viewmodels

import androidx.lifecycle.*
import com.example.movildev.model.Factura
import com.example.movildev.repositories.FacturaRepository
import kotlinx.coroutines.launch

class FacturaViewModel(private val repository: FacturaRepository) : ViewModel() {

    val facturas: LiveData<List<Factura>> = repository.obtenerFacturas()

    fun guardarFactura(factura: Factura) {
        viewModelScope.launch {
            repository.guardarFactura(factura)
        }
    }

    fun eliminarFactura(factura: Factura) {
        viewModelScope.launch {
            repository.eliminarFactura(factura)
        }
    }
}

