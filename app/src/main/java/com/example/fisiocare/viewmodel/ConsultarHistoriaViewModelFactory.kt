package com.example.fisiocare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fisiocare.repository.HistoriaClinicaRepository

class ConsultarHistoriaViewModelFactory(
    private val repository: HistoriaClinicaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ConsultarHistoriaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ConsultarHistoriaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
