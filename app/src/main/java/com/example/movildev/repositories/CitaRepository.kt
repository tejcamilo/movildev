package com.example.movildev.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movildev.model.Cita
import com.example.movildev.model.Factura


class CitaRepository {

    private val listaCitas = mutableListOf<Cita>()
    private val citasLiveData = MutableLiveData<List<Cita>>(listaCitas)

    fun obtenerCitas(): LiveData<List<Cita>> = citasLiveData

    fun guardarCita(cita: Cita, callback: (Boolean) -> Unit) {
        val index = listaCitas.indexOfFirst { it.id == cita.id }
        if (index != -1) {
            listaCitas[index] = cita
        } else {
            listaCitas.add(cita)
        }
        callback(true)
        citasLiveData.value = listaCitas.toList()
    }

    fun eliminarCita(cita: Cita) {
        listaCitas.remove(cita)
        citasLiveData.value = listaCitas.toList()
    }
}

