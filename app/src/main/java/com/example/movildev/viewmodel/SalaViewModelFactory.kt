package com.example.movildev.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movildev.model.Citas

class SalaViewModelFactory(private val cita: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SalaViewModel::class.java))
            return SalaViewModel(cita) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}