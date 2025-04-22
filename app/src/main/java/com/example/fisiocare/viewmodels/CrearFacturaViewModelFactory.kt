package com.example.fisiocare.viewmodels



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fisiocare.repositories.FacturaRepository

class CrearFacturaViewModelFactory(
    private val repository: FacturaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CrearFacturaViewModel::class.java)) {
            return CrearFacturaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
