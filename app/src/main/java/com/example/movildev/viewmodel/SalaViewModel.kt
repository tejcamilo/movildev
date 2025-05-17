package com.example.movildev.viewmodel

import androidx.lifecycle.ViewModel

class SalaViewModel(detalleCita : String) : ViewModel() {
    val cita = detalleCita
}