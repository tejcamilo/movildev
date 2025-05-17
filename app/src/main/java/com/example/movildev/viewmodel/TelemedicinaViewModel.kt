package com.example.movildev.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class TelemedicinaViewModel : ViewModel() {

    // propiedades a ser inicializadas cuando se crea el objeto desde ViewModelProvider
    val cita: String = "valor a pasar"


    init {
        // this runs when the class is initialized
        Log.i("TelemedicinaViewModel", "ViewModel created")
    }

    fun doSomething(){
        Log.i("TelemedicinaViewModel", "doSomething called")
    }

    override fun onCleared() {
        Log.i("TelemedicinaViewModel", "ViewModel cleared") // p. 466
    }
}