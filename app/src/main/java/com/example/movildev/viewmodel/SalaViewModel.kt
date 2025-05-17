package com.example.movildev.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movildev.model.Citas

class SalaViewModel(detalleCita : String) : ViewModel() {
    val cita = detalleCita
}