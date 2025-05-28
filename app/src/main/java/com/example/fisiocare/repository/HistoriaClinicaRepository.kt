package com.example.fisiocare.repository

import android.content.Context
import com.example.fisiocare.Model.HistoriaClinica
import com.example.fisiocare.database.AppDatabase
import com.example.fisiocare.database.HistoriaClinicaDao

class HistoriaClinicaRepository(context: Context) {

    private val dao: HistoriaClinicaDao =
        AppDatabase.getInstance(context).historiaClinicaDao()

    suspend fun insertar(historia: HistoriaClinica) {
        dao.insertar(historia)
    }

    // Otros métodos si los necesitas (consultas, actualizaciones...)
}
