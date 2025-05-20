package com.example.movildev.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movildev.model.Factura

@Dao
interface FacturaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(factura: Factura)

    @Query("SELECT * FROM facturas ORDER BY fecha DESC")
    fun obtenerFacturas(): LiveData<List<Factura>>

    @Delete
    suspend fun eliminar(factura: Factura)
}
