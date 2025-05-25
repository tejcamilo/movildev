package com.example.movildev.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movildev.model.Factura


class FacturaRepository {
    private val listaFacturas = mutableListOf<Factura>()
    private val facturasLiveData = MutableLiveData<List<Factura>>(listaFacturas)

    fun obtenerFacturas(): LiveData<List<Factura>> = facturasLiveData

    fun guardarFactura(factura: Factura, callback: (Boolean) -> Unit) {
        listaFacturas.add(factura)
        facturasLiveData.value = listaFacturas.toList() // emite nueva lista
        callback(true) // notifica que todo salió bien
    }

    fun eliminarFactura(factura: Factura) {
        listaFacturas.remove(factura)
        facturasLiveData.value = listaFacturas.toList()
    }
}

