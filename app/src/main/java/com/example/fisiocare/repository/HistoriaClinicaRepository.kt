package com.example.fisiocare.repository

import com.example.fisiocare.database.dao.HistoriaClinicaDao
import com.example.fisiocare.Model.HistoriaClinica

class HistoriaClinicaRepository(private val dao: HistoriaClinicaDao) {

    suspend fun insertarHistoria(historia: HistoriaClinica) {
        dao.insertarHistoria(historia)
    }

    suspend fun obtenerHistoriaPorId(id: Int): HistoriaClinica? {
        return dao.obtenerHistoriaPorId(id)
    }
}
