package com.example.fisiocare.repository

import android.content.Context
import com.example.fisiocare.database.AppDatabase

object HistoriaClinicaRepositorySingleton {

    // Repositorio privado no nulo después de inicialización
    private lateinit var repository: HistoriaClinicaRepository

    fun initialize(context: Context) {
        if (!::repository.isInitialized) {
            val database = AppDatabase.getDatabase(context)
            repository = HistoriaClinicaRepository(database.historiaClinicaDao())
        }
    }

    fun get(): HistoriaClinicaRepository {
        if (!::repository.isInitialized) {
            throw IllegalStateException("HistoriaClinicaRepositorySingleton debe inicializarse antes de usarlo.")
        }
        return repository
    }
}
