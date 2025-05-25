package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movildev.R

class FacturaElectronicaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_factura_electronica, container, false)

        val inputNombre = view.findViewById<EditText>(R.id.inputNombre)
        val inputDocumento = view.findViewById<EditText>(R.id.inputDocumento)
        val inputTelefono = view.findViewById<EditText>(R.id.inputTelefono)
        val inputCorreo = view.findViewById<EditText>(R.id.inputCorreo)
        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)

        btnGuardar.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val documento = inputDocumento.text.toString()
            val telefono = inputTelefono.text.toString()
            val correo = inputCorreo.text.toString()

            if (nombre.isNotBlank() && documento.isNotBlank() && correo.isNotBlank()) {
                // Aquí puedes guardar en una lista, base de datos o log
                Toast.makeText(requireContext(), "Factura electrónica guardada ✅", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_facturaElectronicaFragment_to_consultarFacturasFragment)
            } else {
                Toast.makeText(requireContext(), "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(requireContext(), "Operación cancelada ❌", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_facturaElectronicaFragment_to_crearFacturaFragment)
        }

        return view
    }
}
