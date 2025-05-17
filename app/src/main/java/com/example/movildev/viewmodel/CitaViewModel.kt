package com.example.movildev.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movildev.model.Cita
import com.example.movildev.model.CitaDao
import kotlinx.coroutines.launch

class CitaViewModel(val dao: CitaDao) : ViewModel() {
    var fecha = ""
    var hora = ""
    var tipo = ""
    var modalidad = ""
    var profesional = ""
    var disponible = true

    fun addCita() {
        // launch coroutine in the same scope as the ViewModel
        viewModelScope.launch {
            val cita = Cita(
                fecha = fecha,
                hora = hora,
                tipo = tipo,
                modalidad = modalidad,
                profesional = profesional,
                disponible = disponible
            )
            dao.insert(cita)
        }
    }
}