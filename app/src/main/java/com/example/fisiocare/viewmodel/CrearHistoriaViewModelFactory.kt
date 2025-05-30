package com.example.fisiocare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fisiocare.repository.HistoriaClinicaRepository

class CrearHistoriaViewModelFactory(private val repository: HistoriaClinicaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CrearHistoriaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CrearHistoriaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
