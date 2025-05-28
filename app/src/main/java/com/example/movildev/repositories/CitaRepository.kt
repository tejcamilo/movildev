package com.example.movildev.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movildev.model.Cita
import com.example.movildev.model.Factura
import java.util.UUID


class CitaRepository {

    val listaCitas : MutableList<Cita> = mutableListOf(
        Cita(
            id = UUID.randomUUID().toString(),
            fecha = "2025-06-10",
            hora = "10:00 AM",
            tratamiento = "Consulta",
            paciente = "Paciente1",
            modalidad = "Telemedicina",
            profesional = "Cathalina Cañon",
            disponible = false
        ),
        Cita(
            id = UUID.randomUUID().toString(),
            fecha = "2025-06-30",
            hora = "11:30 AM",
            tratamiento = "Control",
            paciente = "Paciente1",
            modalidad = "Telemedicina",
            profesional = "Cathalina Cañon",
            disponible = false
        ),
        Cita(
            id = UUID.randomUUID().toString(),
            fecha = "2025-08-05",
            hora = "03:30 PM",
            tratamiento = "Control",
            paciente = "Paciente1",
            modalidad = "Telemedicina",
            profesional = "Cathalina Cañon",
            disponible = false
        ),
        Cita(
            id = UUID.randomUUID().toString(),
            fecha = "2025-07-05",
            hora = "09:00 AM",
            tratamiento = "Consulta",
            paciente = "Paciente1",
            modalidad = "Presencial",
            profesional = "Cathalina Cañon",
            disponible = true
        ),
        Cita(
            id = UUID.randomUUID().toString(),
            fecha = "2025-07-12",
            hora = "02:00 PM",
            tratamiento = "Revisión",
            paciente = "Paciente1",
            modalidad = "Telemedicina",
            profesional = "Cathalina Cañon",
            disponible = true
        ),
        Cita(
            id = UUID.randomUUID().toString(),
            fecha = "2025-07-20",
            hora = "04:30 PM",
            tratamiento = "Control",
            paciente = "Paciente1",
            modalidad = "Presencial",
            profesional = "Cathalina Cañon",
            disponible = false
        ),
        Cita(
            id = UUID.randomUUID().toString(),
            fecha = "2025-08-01",
            hora = "08:15 AM",
            tratamiento = "Consulta",
            paciente = "Paciente1",
            modalidad = "Telemedicina",
            profesional = "Cathalina Cañon",
            disponible = true
        ),
        Cita(
            id = UUID.randomUUID().toString(),
            fecha = "2025-08-10",
            hora = "03:45 PM",
            tratamiento = "Control",
            paciente = "Paciente1",
            modalidad = "Presencial",
            profesional = "Cathalina Cañon",
            disponible = true
        )
    )

    private val citasLiveData = MutableLiveData<List<Cita>>(listaCitas)

    fun obtenerCitas(): LiveData<List<Cita>> = citasLiveData

    fun guardarCita(cita: Cita, callback: (Boolean) -> Unit) {
        val index = listaCitas.indexOfFirst { it.id == cita.id }
        if (index != -1) {
            listaCitas[index] = cita
        } else {
            listaCitas.add(cita)
        }
        callback(true)
        citasLiveData.value = listaCitas.toList()
    }

    fun eliminarCita(cita: Cita) {
        listaCitas.remove(cita)
        citasLiveData.value = listaCitas.toList()
    }
}

