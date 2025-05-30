package com.example.movildev.viewmodels

import androidx.lifecycle.ViewModel
import com.example.movildev.model.Cita

class SalaViewModel(private val cita : Cita) : ViewModel() {
    fun getCita(): Cita = cita
}