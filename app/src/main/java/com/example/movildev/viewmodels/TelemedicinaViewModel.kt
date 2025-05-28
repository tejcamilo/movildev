package com.example.movildev.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movildev.model.Cita
import com.example.movildev.repositories.CitaRepository

class TelemedicinaViewModel : ViewModel() {

    private lateinit var viewModel : CitaViewModel
    private var _citas = viewModel.citas
    val citas: LiveData<List<Cita>> get() = _citas

    // propiedades a ser inicializadas cuando se crea el objeto desde ViewModelProvider
    val cita: String = "valor a pasar"


    init {
        // this runs when the class is initialized
        Log.i("TelemedicinaViewModel", "ViewModel created")
    }

    fun getCitasAgendadas(): LiveData<List<Cita>> {
        val sortedList = _citas.value
            ?.filter { !it.disponible }
            ?.sortedBy { it.fecha }
            ?: emptyList()
        return MutableLiveData(sortedList)
    }

    fun getTelemedicinaCitas(): LiveData<List<Cita>> {
        val sortedList = _citas.value
            ?.filter { it.modalidad == "Telemedicina" && !it.disponible }
            ?.sortedBy { it.fecha }
            ?: emptyList()
        return MutableLiveData(sortedList)
    }

    fun cancelar(cita: Cita) {
        viewModel.cancelarCita(cita)
    }

    fun doSomething(){
        Log.i("TelemedicinaViewModel", "doSomething called")
    }

    override fun onCleared() {
        Log.i("TelemedicinaViewModel", "ViewModel cleared") // p. 466
    }
}