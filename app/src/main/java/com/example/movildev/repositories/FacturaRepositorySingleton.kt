package com.example.movildev.repositories

object FacturaRepositorySingleton {
    val instance: FacturaRepository by lazy { FacturaRepository() }
}
