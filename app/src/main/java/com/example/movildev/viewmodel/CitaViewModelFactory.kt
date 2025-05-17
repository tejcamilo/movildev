package com.example.movildev.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movildev.model.CitaDao

class CitaViewModelFactory(private val dao: CitaDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CitaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CitaViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}