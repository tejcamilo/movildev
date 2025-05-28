package com.example.movildev.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movildev.repositories.CitaRepository
import com.example.movildev.repositories.FacturaRepository

class CitaViewModelFactory(private val repository: CitaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CitaViewModel::class.java)) {
            return CitaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}