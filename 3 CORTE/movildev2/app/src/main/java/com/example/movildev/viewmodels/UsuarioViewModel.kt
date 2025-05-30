package com.example.movildev.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.ViewModel
import com.example.movildev.model.Usuario

class UsuarioViewModel : ViewModel() {

    private val _usuarios = MutableLiveData<List<Usuario>>()
    val usuarios: LiveData<List<Usuario>> get() = _usuarios

    init {
        _usuarios.value = listOf(
            Usuario(1, "Juan Pérez", "Cédula", "123456789", "01/01/1990", "juan.perez@example.com","Catalina Cañon","3024778127"),
            Usuario(2, "María Gómez", "Pasaporte", "A9876543", "15/05/1985", "maria.gomez@example.com","Catalina Cañon","3103305802")
        )
    }

    /** Devuelve el usuario con el ID dado o null si no existe */
    fun obtenerUsuarioPorId(id: Int): LiveData<Usuario?> {
        return usuarios.map { lista ->
            lista.find { it.id == id }
        }
    }

    /** Elimina el usuario de la lista */
    fun eliminarUsuario(usuario: Usuario) {
        _usuarios.value = _usuarios.value
            ?.filter { it.id != usuario.id }

    }
    fun agregarUsuario(usuario: Usuario) {
        val actuales = _usuarios.value.orEmpty().toMutableList()
        actuales.add(usuario)
        _usuarios.value = actuales
    }

    /** Reemplaza el usuario con el mismo ID por la versión actualizada */
    fun actualizarUsuario(usuario: Usuario) {
        val actuales = _usuarios.value.orEmpty().map {
            if (it.id == usuario.id) usuario else it
        }
        _usuarios.value = actuales
    }
}
