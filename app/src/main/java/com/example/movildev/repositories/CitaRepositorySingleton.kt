package com.example.movildev.repositories


import com.example.movildev.repositories.CitaRepository


object CitaRepositorySingleton {
    val instance: CitaRepository by lazy { CitaRepository() }
}
