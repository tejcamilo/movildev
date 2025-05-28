package com.example.fisiocare.repository

import android.content.Context
import com.example.fisiocare.database.AppDatabase

object HistoriaClinicaRepositorySingleton {

    private var repository: HistoriaClinicaRepository? = null

    fun initialize(context: Context) {
        val database = AppDatabase.getDatabase(context)
        repository = HistoriaClinicaRepository(database.historiaClinicaDao())
    }

    fun get(): HistoriaClinicaRepository {
        return repository
            ?: throw IllegalStateException("HistoriaRepositorySingleton debe inicializarse antes de usarlo.")
    }
}
