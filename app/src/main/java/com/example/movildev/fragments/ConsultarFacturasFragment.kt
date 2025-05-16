package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movildev.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.movildev.model.Factura


class ConsultarFacturasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_consultar_factura, container, false)

        val descargarBtn = view.findViewById<Button>(R.id.acceder_btn)
        descargarBtn.setOnClickListener {
            Toast.makeText(requireContext(), "📥 Descargando factura...", Toast.LENGTH_SHORT).show()
        }

        // 🟨 Al hacer clic en la card se envía la factura a modificar
        val frame1 = view.findViewById<LinearLayout>(R.id.frame1)
        frame1.setOnClickListener {
            val factura = Factura(
                id = "F-001",
                paciente = "Camila Martínez",
                tratamiento = "Fisioterapia",
                valor = 120000.0
            )

            val bundle = Bundle().apply {
                putSerializable("factura", factura)
            }

            view.findNavController().navigate(R.id.action_consultarFacturasFragment_to_crearFacturaFragment, bundle)
        }

        // ➕ Botón flotante para crear nueva factura
        val fabAgregar = view.findViewById<FloatingActionButton>(R.id.fabAgregar)
        fabAgregar.setOnClickListener {
            view.findNavController().navigate(R.id.action_consultarFacturasFragment_to_crearFacturaFragment)
        }

        return view
    }
}
