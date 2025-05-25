package com.example.movildev.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movildev.model.Factura


class FacturaRepository {
    private val listaFacturas = mutableListOf<Factura>()
    private val facturasLiveData = MutableLiveData<List<Factura>>(listaFacturas)

    fun obtenerFacturas(): LiveData<List<Factura>> = facturasLiveData

    fun guardarFactura(factura: Factura, callback: (Boolean) -> Unit) {
        val index = listaFacturas.indexOfFirst { it.id == factura.id }
        if (index != -1) {
            listaFacturas[index] = factura
        } else {
            listaFacturas.add(factura)
        }
        callback(true)
        facturasLiveData.value = listaFacturas
    }


    fun eliminarFactura(factura: Factura) {
        listaFacturas.remove(factura)
        facturasLiveData.value = listaFacturas.toList()
    }
}

