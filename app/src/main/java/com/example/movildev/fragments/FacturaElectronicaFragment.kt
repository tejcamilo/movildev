package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)

        btnGuardar.setOnClickListener {
            Toast.makeText(requireContext(), "Factura electrónica guardada ✅", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_facturaElectronicaFragment_to_consultarFacturasFragment)
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(requireContext(), "Operación cancelada ❌", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_facturaElectronicaFragment_to_crearFacturaFragment)
        }

        return view
    }
}
