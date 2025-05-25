package com.example.movildev.repositories


import com.example.movildev.database.FacturaDao
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movildev.model.Factura


class FacturaRepository {
    // Lista simulada en memoria
    private val listaFacturas = mutableListOf<Factura>()
    private val facturasLiveData = MutableLiveData<List<Factura>>()

    init {
        facturasLiveData.value = listaFacturas
    }
    fun guardarFactura(factura: Factura, callback: (Boolean) -> Unit) {
        try {
            listaFacturas.add(factura)
            facturasLiveData.value = listaFacturas.toList() // Actualiza la lista observable
            callback(true)
        } catch (e: Exception) {
            callback(false)
        }
    }

    fun obtenerFacturas(): LiveData<List<Factura>> {
        return facturasLiveData
    }

    fun eliminarFactura(factura: Factura) {
        listaFacturas.remove(factura)
        facturasLiveData.value = listaFacturas.toList() // Actualiza LiveData
    }
}

