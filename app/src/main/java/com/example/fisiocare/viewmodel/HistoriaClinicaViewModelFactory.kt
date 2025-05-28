package com.example.fisiocare.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fisiocare.repository.HistoriaClinicaRepository

class HistoriaClinicaViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoriaClinicaViewModel::class.java)) {
            val repository = HistoriaClinicaRepository(context)
            return HistoriaClinicaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
