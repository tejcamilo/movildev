package com.example.movildev.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movildev.model.Cita
import com.example.movildev.repositories.CitaRepository

class TelemedicinaViewModel(private val repository: CitaRepository) : ViewModel() {

    val citas: LiveData<List<Cita>> = repository.obtenerCitas()


    // propiedades a ser inicializadas cuando se crea el objeto desde ViewModelProvider
    val cita: String = "valor a pasar"


    fun getCitasAgendadas(): LiveData<List<Cita>> {
        val sortedList = citas.value
            ?.filter { !it.disponible }
            ?.sortedBy { it.fecha }
            ?: emptyList()
        return MutableLiveData(sortedList)
    }

    fun getTelemedicinaCitas(): LiveData<List<Cita>> {
        val sortedList = citas.value
            ?.filter { it.modalidad == "Virtual" && !it.disponible }
            ?.sortedBy { it.fecha }
            ?: emptyList()
        return MutableLiveData(sortedList)
    }

        fun cancelar(cita: Cita) {
        repository.eliminarCita(cita)
    }


    override fun onCleared() {
        Log.i("TelemedicinaViewModel", "ViewModel cleared")
    }
}