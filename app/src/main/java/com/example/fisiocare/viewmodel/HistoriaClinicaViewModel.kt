package com.example.fisiocare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fisiocare.Model.HistoriaClinica
import com.example.fisiocare.repository.HistoriaClinicaRepository
import kotlinx.coroutines.launch

class HistoriaClinicaViewModel(private val repository: HistoriaClinicaRepository) : ViewModel() {

    fun insertar(historia: HistoriaClinica) {
        viewModelScope.launch {
            repository.insertar(historia)
        }
    }
}
