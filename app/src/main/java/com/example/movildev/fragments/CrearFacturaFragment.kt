package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movildev.R
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.example.movildev.model.Factura

class CrearFacturaFragment : Fragment() {

    // Datos simulados por ID de paciente
    private val datosPaciente = mapOf(
        "Juan Perez" to Triple("12345678", "3100000001", "juan@example.com"),
        "Laura Gómez" to Triple("98765432", "3150000002", "laura@example.com")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_crear_factura, container, false)

        // Referencias a campos
        val nombreInput = view.findViewById<EditText>(R.id.idNombre)
        val documentoInput = view.findViewById<EditText>(R.id.idDocumento)
        val telefonoInput = view.findViewById<EditText>(R.id.idTelefono)
        val valorInput = view.findViewById<EditText>(R.id.inputValor)
        val tratamientoInput = view.findViewById<AutoCompleteTextView>(R.id.selectorTratamiento)
        val feInput = view.findViewById<AutoCompleteTextView>(R.id.selectorFE)

        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)

        // Adaptador selector factura electrónica
        val opcionesFE = listOf("Sí", "No")
        feInput.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, opcionesFE))

        // Adaptador selector tratamiento (puedes reemplazar por tus valores reales)
        val tratamientos = listOf("Terapia Física", "Rehabilitación", "Consulta")
        tratamientoInput.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, tratamientos))

        // Verifica si estás modificando (recibes argumentos)
        val args = arguments
        if (args != null) {
            nombreInput.setText(args.getString("paciente"))
            tratamientoInput.setText(args.getString("tratamiento"))
            valorInput.setText(args.getDouble("valor", 0.0).toString())

            // También puedes setear documento y teléfono si los recibes
            documentoInput.setText(args.getString("documento"))
            telefonoInput.setText(args.getString("telefono"))
        }

        // Autocompletar datos al escribir nombre
        nombreInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val nombre = nombreInput.text.toString()
                datosPaciente[nombre]?.let { (documento, telefono, correo) ->
                    documentoInput.setText(documento)
                    telefonoInput.setText(telefono)
                    // Aquí podrías también setear un campo correo si existiera
                }
            }
        }

        // Guardar
        btnGuardar.setOnClickListener {
            val paciente = nombreInput.text.toString()
            val tratamiento = tratamientoInput.text.toString()
            val valor = valorInput.text.toString().toDoubleOrNull() ?: 0.0
            val esElectronica = feInput.text.toString()

            if (paciente.isNotBlank() && tratamiento.isNotBlank() && valor > 0) {
                Toast.makeText(requireContext(), "Factura guardada correctamente ✅", Toast.LENGTH_SHORT).show()

                if (esElectronica == "Sí") {
                    view.findNavController().navigate(R.id.action_crearFacturaFragment_to_facturaElectronicaFragment)
                } else {
                    view.findNavController().navigate(R.id.action_crearFacturaFragment_to_consultarFacturasFragment)
                }
            } else {
                Toast.makeText(requireContext(), "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Cancelar
        btnCancelar.setOnClickListener {
            view.findNavController().navigate(R.id.action_crearFacturaFragment_to_consultarFacturasFragment)
        }

        return view
    }
}

