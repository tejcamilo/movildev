package com.example.fisiocare.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fisiocare.Model.HistoriaClinica
import com.example.fisiocare.repository.HistoriaClinicaRepository
import kotlinx.coroutines.launch

class ConsultarHistoriaViewModel(
    private val repository: HistoriaClinicaRepository
) : ViewModel() {

    private val _historiaClinica = MutableLiveData<HistoriaClinica?>()
    val historiaClinica: LiveData<HistoriaClinica?> = _historiaClinica

    fun consultarHistoriaPorId(id: String) {
        val idInt = id.toIntOrNull()
        if (idInt != null) {
            viewModelScope.launch {
                val historia = repository.obtenerHistoriaPorId(idInt)
                _historiaClinica.postValue(historia)
            }
        } else {
            // Maneja el error: ID inválido
            _historiaClinica.postValue(null)
        }
    }
}
