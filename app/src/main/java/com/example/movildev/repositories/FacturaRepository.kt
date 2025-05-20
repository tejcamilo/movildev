package com.example.movildev.repositories

import androidx.lifecycle.LiveData
import com.example.movildev.database.FacturaDao
import com.example.movildev.model.Factura

class FacturaRepository(private val facturaDao: FacturaDao) {

    suspend fun guardarFactura(factura: Factura) {
        facturaDao.insertar(factura)
    }

    fun obtenerFacturas(): LiveData<List<Factura>> {
        return facturaDao.obtenerFacturas()
    }

    suspend fun eliminarFactura(factura: Factura) {
        facturaDao.eliminar(factura)
    }
}



