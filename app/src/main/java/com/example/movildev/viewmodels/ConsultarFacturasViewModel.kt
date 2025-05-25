package com.example.movildev.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movildev.model.Factura
import com.example.movildev.repositories.FacturaRepository

class ConsultarFacturasViewModel(
    private val repository: FacturaRepository
) : ViewModel() {


    val facturas: LiveData<List<Factura>> = repository.obtenerFacturas()

    fun eliminarFactura(factura: Factura) {
        repository.eliminarFactura(factura)
    }
}
