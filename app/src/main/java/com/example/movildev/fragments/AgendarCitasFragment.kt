package com.example.movildev.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movildev.R
import com.example.movildev.model.Cita
import com.example.movildev.repositories.CitaRepositorySingleton
import com.example.movildev.viewmodels.CitaViewModel
import com.example.movildev.viewmodels.CitaViewModelFactory
import java.util.*

class AgendarCitasFragment : Fragment() {

    private lateinit var viewModel: CitaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_agendarcitas, container, false)

        // ViewModel + Repo
        val viewModelFactory = CitaViewModelFactory(CitaRepositorySingleton.instance)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[CitaViewModel::class.java]

        // Inputs
        val nombreInput = view.findViewById<EditText>(R.id.idNombreCita)
        val modalidadInput = view.findViewById<AutoCompleteTextView>(R.id.selectorModalidad)
        val horaInput = view.findViewById<AutoCompleteTextView>(R.id.selectorHora)
        val fechaInput = view.findViewById<EditText>(R.id.tv_fecha_picker)
        val tratamientoInput = view.findViewById<AutoCompleteTextView>(R.id.selectorTratamientoCita)

        val btnGuardar = view.findViewById<Button>(R.id.btnGuardarCitas)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelarCitas)

        // Set adapters
        val opcionesHora = listOf("8:00 AM", "9:00 AM", "10:00 AM")
        val opcionesModalidad = listOf("Presencial", "Telemedicina")
        val opcionesTratamientos = listOf("Terapia Física", "Rehabilitación", "Consulta")

        horaInput.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, opcionesHora))
        modalidadInput.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, opcionesModalidad))
        tratamientoInput.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, opcionesTratamientos))

        // Date Picker
        fechaInput.setOnClickListener {
            mostrarDatePicker(fechaInput)
        }
        var idCita = System.currentTimeMillis().toString() // default si no se edita una cita
        val args = arguments
        if (args != null) {
            idCita = args.getString("id") ?: idCita
            nombreInput.setText(args.getString("paciente"))
            tratamientoInput.setText(args.getString("tratamiento"))
            modalidadInput.setText(args.getString("modalidad"))
            fechaInput.setText(args.getString("fecha"))
            horaInput.setText(args.getString("hora"))
        }
        // Guardar cita
        btnGuardar.setOnClickListener {
            val paciente = nombreInput.text.toString()
            val modalidad = modalidadInput.text.toString()
            val hora = horaInput.text.toString()
            val fecha = fechaInput.text.toString()
            val tratamiento = tratamientoInput.text.toString()

            if (paciente.isNotBlank() && tratamiento.isNotBlank() && fecha.isNotBlank() && hora.isNotBlank()) {
                val id = UUID.randomUUID().toString()

                val cita = Cita(
                    id = id,
                    fecha = fecha,
                    hora = hora,
                    paciente = paciente,
                    tratamiento = tratamiento,
                    modalidad = modalidad,
                    disponible = false,
                    profesional = "Cathalina"
                )

                viewModel.guardarCita(cita) { success ->
                    if (success) {
                        Toast.makeText(context, "✅ Guardado exitosamente", Toast.LENGTH_SHORT).show()
                        viewModel.seleccionarCita(cita)
                        view.findNavController().navigate(R.id.action_agendarCitasFragment_to_citasFragment)
                    } else {
                        Toast.makeText(context, "❌ Error al guardar", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Cancelar
        btnCancelar.setOnClickListener {
            view.findNavController().navigate(R.id.action_agendarCitasFragment_to_citasFragment)
        }
        horaInput.setOnClickListener {
            horaInput.showDropDown()
        }
        modalidadInput.setOnClickListener {
            modalidadInput.showDropDown()
        }
        tratamientoInput.setOnClickListener {
            tratamientoInput.showDropDown()
        }
        return view
    }

    private fun mostrarDatePicker(fechaInput: EditText) {
        val calendario = Calendar.getInstance()
        val año = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, añoSel, mesSel, diaSel ->
            val fechaFormateada = String.format("%04d-%02d-%02d", añoSel, mesSel + 1, diaSel)
            fechaInput.setText(fechaFormateada)
        }, año, mes, dia)

        datePickerDialog.show()
    }
}
