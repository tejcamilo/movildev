package com.example.movildev.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movildev.model.Cita
import com.example.movildev.repositories.CitaRepository

class CitaViewModel(private val repository: CitaRepository) : ViewModel() {

    val citas: LiveData<List<Cita>> = repository.obtenerCitas()

    private val _citaSeleccionada = MutableLiveData<Cita?>()
    val citaSeleccionada: LiveData<Cita?> get() = _citaSeleccionada

    fun guardarCita(Cita: Cita, callback: (Boolean) -> Unit) {
        repository.guardarCita(Cita, callback)
    }

    fun cancelarCita(Cita: Cita) {
        repository.eliminarCita(Cita)
    }

    fun seleccionarCita(Cita: Cita) {
        _citaSeleccionada.value = Cita
    }
}