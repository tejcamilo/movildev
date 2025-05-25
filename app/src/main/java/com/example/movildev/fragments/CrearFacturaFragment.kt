package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movildev.R
import com.example.movildev.model.Factura
import com.example.movildev.repositories.FacturaRepository
import com.example.movildev.repositories.FacturaRepositorySingleton
import com.example.movildev.viewmodels.FacturaViewModel
import com.example.movildev.viewmodels.FacturaViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class CrearFacturaFragment : Fragment() {

    private lateinit var viewModel: FacturaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crear_factura, container, false)

        // ViewModel + Repo
        val viewModelFactory = FacturaViewModelFactory(FacturaRepositorySingleton.instance)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[FacturaViewModel::class.java]
// Inputs
        val nombreInput = view.findViewById<EditText>(R.id.idNombre)
        val documentoInput = view.findViewById<EditText>(R.id.idDocumento)
        val telefonoInput = view.findViewById<EditText>(R.id.idTelefono)
        val valorInput = view.findViewById<EditText>(R.id.inputValor)
        val tratamientoInput = view.findViewById<AutoCompleteTextView>(R.id.selectorTratamiento)
        val feInput = view.findViewById<AutoCompleteTextView>(R.id.selectorFE)

        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)

        val opcionesFE = listOf("Sí", "No")
        feInput.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                opcionesFE
            )
        )

        val tratamientos = listOf("Terapia Física", "Rehabilitación", "Consulta")
        tratamientoInput.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                tratamientos
            )
        )

        btnGuardar.setOnClickListener {
            val paciente = nombreInput.text.toString()
            val tratamiento = tratamientoInput.text.toString()
            val valor = valorInput.text.toString().toDoubleOrNull() ?: 0.0
            val esElectronica = feInput.text.toString()

            if (paciente.isNotBlank() && tratamiento.isNotBlank() && valor > 0) {
                val id = System.currentTimeMillis().toString()
                val now = Date()
                val fechaActual = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(now)
                val horaActual = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now)

                val factura = Factura(
                    id = id,
                    fecha = fechaActual,
                    hora = horaActual,
                    paciente = paciente,
                    tratamiento = tratamiento,
                    valor = valor
                )
                viewModel.guardarFactura(factura) { success ->
                    if (success) {
                        Toast.makeText(context, "Guardado exitosamente ✅", Toast.LENGTH_SHORT)
                            .show()

                        if (esElectronica == "Sí") {
                            view.findNavController()
                                .navigate(R.id.action_crearFacturaFragment_to_facturaElectronicaFragment)
                        } else {
                            view.findNavController()
                                .navigate(R.id.action_crearFacturaFragment_to_consultarFacturasFragment)
                        }

                    } else {
                        Toast.makeText(context, "Error al guardar ❌", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Por favor completa todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnCancelar.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_crearFacturaFragment_to_consultarFacturasFragment)
        }

        feInput.setOnClickListener { feInput.showDropDown() }
        tratamientoInput.setOnClickListener { tratamientoInput.showDropDown() }

        return view
    }
}