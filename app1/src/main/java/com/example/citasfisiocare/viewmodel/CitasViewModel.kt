package com.example.citasfisiocare.viewmodel
import androidx. lifecycle. ViewModel
import androidx. lifecycle. MutableLiveData
import com. example. citasfisiocare. repository. CitaRepository
import com. example. citasfisiocare. model. Cita1
import androidx. lifecycle. LiveData

//class CitaViewModel : ViewModel() {
//    private val repository = CitaRepository()
//
//    private val _citas = MutableLiveData<List<Cita1>>()
//    val citas: LiveData<List<Cita1>> = _citas
//
//    fun agregarCita(cita: Cita1) {
//        repository.agregarCita(cita)
//        _citas.value = repository.obtenerCitas()
//    }
//}
