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
import com.example.movildev.repositories.FacturaRepositorySingleton
import com.example.movildev.viewmodels.FacturaViewModel
import com.example.movildev.viewmodels.FacturaViewModelFactory

class FacturaElectronicaFragment : Fragment() {

    private lateinit var facturaViewModel: FacturaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_factura_electronica, container, false)

        facturaViewModel = ViewModelProvider(
            requireActivity(),
            FacturaViewModelFactory(FacturaRepositorySingleton.instance)
        )[FacturaViewModel::class.java]

        val inputNombre = view.findViewById<EditText>(R.id.inputNombre)
        val inputDocumento = view.findViewById<EditText>(R.id.inputDocumento)
        val inputTelefono = view.findViewById<EditText>(R.id.inputTelefono)
        val inputCorreo = view.findViewById<EditText>(R.id.inputCorreo)
        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)

        btnGuardar.setOnClickListener {
            val razonSocial = inputNombre.text.toString()
            val nit = inputDocumento.text.toString()
            val telefono = inputTelefono.text.toString()
            val correo = inputCorreo.text.toString()

            val factura = facturaViewModel.facturaSeleccionada.value

            if (razonSocial.isNotBlank() && nit.isNotBlank() && correo.isNotBlank() && factura != null) {
                val facturaActualizada = factura.copy(
                    razonSocial = razonSocial,
                    nit = nit,
                    telefono = telefono,
                    correo = correo
                )

                facturaViewModel.guardarFactura(facturaActualizada) { success ->
                    if (success) {
                        Toast.makeText(
                            requireContext(),
                            "Factura electrónica actualizada ✅",
                            Toast.LENGTH_SHORT
                        ).show()
                        view.findNavController()
                            .navigate(R.id.action_facturaElectronicaFragment_to_consultarFacturasFragment)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Error al guardar ❌",
                            Toast.LENGTH_SHORT
                        ).show()
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
            Toast.makeText(requireContext(), "Operación cancelada ❌", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_facturaElectronicaFragment_to_consultarFacturasFragment)
        }

        return view
    }
}
