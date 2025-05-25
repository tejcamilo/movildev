package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.R
import com.example.movildev.adapters.FacturaAdapter
import com.example.movildev.model.Factura
import com.example.movildev.repositories.FacturaRepository
import com.example.movildev.viewmodels.FacturaViewModel
import com.example.movildev.viewmodels.FacturaViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.navigation.findNavController

class ConsultarFacturasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FacturaAdapter
    private lateinit var viewModel: FacturaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_consultar_factura, container, false)

        // ✅ Inicializar ViewModel con repo basado en lista
        val repository = FacturaRepository() // usa la lista interna simulada
        val factory = FacturaViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[FacturaViewModel::class.java]

        // ✅ Configurar RecyclerView
        recyclerView = view.findViewById(R.id.recyclerFacturas)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = FacturaAdapter(
            facturas = emptyList(),
            onModificar = { factura ->
                val bundle = Bundle().apply {
                    putString("paciente", factura.paciente)
                    putString("tratamiento", factura.tratamiento)
                    putDouble("valor", factura.valor)
                    putString("fecha", factura.fecha)
                    putString("hora", factura.hora)
                }
                view.findNavController().navigate(
                    R.id.action_consultarFacturasFragment_to_crearFacturaFragment,
                    bundle
                )
            },
            onEliminar = { factura ->
                viewModel.eliminarFactura(factura)
            }
        )
        recyclerView.adapter = adapter

        // ✅ Observar LiveData del ViewModel
        viewModel.facturas.observe(viewLifecycleOwner) { lista ->
            adapter.updateData(lista)
        }

        // ➕ Botón flotante para crear nueva factura
        val fabAgregar = view.findViewById<FloatingActionButton>(R.id.fabAgregar)
        fabAgregar.setOnClickListener {
            view.findNavController().navigate(R.id.action_consultarFacturasFragment_to_crearFacturaFragment)
        }

        return view
    }
}
