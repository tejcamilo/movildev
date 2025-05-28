package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.R
import com.example.movildev.adapters.CitaAdapter
import com.example.movildev.model.Cita
import com.example.movildev.repositories.CitaRepositorySingleton
import com.example.movildev.viewmodels.CitaViewModel
import com.example.movildev.viewmodels.CitaViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CitasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CitaAdapter
    private lateinit var viewModel: CitaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_citas, container, false)

        // ViewModel
        val viewModelFactory = CitaViewModelFactory(CitaRepositorySingleton.instance)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[CitaViewModel::class.java]

        // RecyclerView
        recyclerView = view.findViewById(R.id.recyclerCitas)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = CitaAdapter(
            citas = emptyList(),
            onReagendar = { cita ->
                val bundle = Bundle().apply {
                    putString("id", cita.id)
                    putString("paciente", cita.paciente)
                    putString("modalidad", cita.modalidad)
                    putString("tratamiento", cita.tratamiento)
                    putString("fecha", cita.fecha)
                    putString("hora", cita.hora)
                }
                view.findNavController().navigate(
                    R.id.action_citasFragment_to_agendarCitasFragment,
                    bundle
                )
            },
            onCancelar = { cita -> // 🟢 corregido nombre de variable
                viewModel.cancelarCita(cita)
            }
        )
        recyclerView.adapter = adapter

        // Observar datos
        viewModel.citas.observe(viewLifecycleOwner) { lista ->
            adapter.updateData(lista)
            // Aquí podrías mostrar un mensaje si está vacío
        }

        // Floating Action Button
        val fabAgregar = view.findViewById<FloatingActionButton>(R.id.fabAgregar)
        fabAgregar.setOnClickListener {
            view.findNavController().navigate(R.id.action_citasFragment_to_agendarCitasFragment)
        }

        // Búsqueda
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { adapter.filtrarPorNombre(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filtrarPorNombre(newText ?: "")
                return true
            }
        })

        return view
    }
}
