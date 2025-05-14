package com.example.movildev.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movildev.model.Citas

class SalaViewModelFactory(private val citaData: Citas) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SalaViewModel::class.java))
            return SalaViewModel(citaData) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}