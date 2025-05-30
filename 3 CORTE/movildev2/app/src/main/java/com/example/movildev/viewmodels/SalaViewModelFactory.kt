package com.example.movildev.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SalaViewModelFactory(private val cita: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SalaViewModel::class.java))
            return SalaViewModel(cita) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}