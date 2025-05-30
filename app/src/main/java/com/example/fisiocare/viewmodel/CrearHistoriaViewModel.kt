package com.example.fisiocare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fisiocare.Model.HistoriaClinica
import com.example.fisiocare.repository.HistoriaClinicaRepository
import kotlinx.coroutines.launch

class CrearHistoriaViewModel(private val repository: HistoriaClinicaRepository) : ViewModel() {

    fun insertarHistoria(
        nombreCompleto: String,
        telefono: String,
        eps: String,
        motivoConsulta: String,
        documento: String
    ) {
        val nuevaHistoria = HistoriaClinica(
            nombreCompleto = nombreCompleto,
            documento = documento,
            telefono = telefono,
            eps = eps,
            motivoConsulta = motivoConsulta
    )



        viewModelScope.launch {
            repository.insertarHistoria(nuevaHistoria)
        }
    }
}
