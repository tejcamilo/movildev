package com.example.movildev.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movildev.model.Cita

class TelemedicinaViewModel : ViewModel() {
    private val _citas = MutableLiveData(InitCitaList.init())
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
        val currentList = _citas.value ?: return
        val newList = currentList.map { cita0 ->
            if (cita0.id == cita.id) cita else cita0
        }
        _citas.value = newList
    }

    fun doSomething(){
        Log.i("TelemedicinaViewModel", "doSomething called")
    }

    override fun onCleared() {
        Log.i("TelemedicinaViewModel", "ViewModel cleared") // p. 466
    }
}