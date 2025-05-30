package com.example.movildev.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movildev.adapters.TelemedicinaItemAdapter
import com.example.movildev.databinding.FragmentTelemedicinaBinding
import com.example.movildev.repositories.CitaRepositorySingleton
import com.example.movildev.viewmodels.TelemedicinaViewModel
import com.example.movildev.viewmodels.TelemedicinaViewModelFactory
import com.example.movildev.R
import com.example.movildev.model.Cita

class TelemedicinaFragment : Fragment() {

    private var _binding: FragmentTelemedicinaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TelemedicinaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTelemedicinaBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(
            requireActivity(),
            TelemedicinaViewModelFactory(CitaRepositorySingleton.instance)
        )[TelemedicinaViewModel::class.java]

        val adapter = TelemedicinaItemAdapter(
            onAccederClick = { cita ->
                val bundle = Bundle().apply {
                    putString("id", cita.id)
                    putString("paciente", cita.paciente)
                    putString("modalidad", cita.modalidad)
                    putString("tratamiento", cita.tratamiento)
                    putString("fecha", cita.fecha)
                    putString("hora", cita.hora)
                }
                view.findNavController().navigate(
                    R.id.action_telemedicinaFragment_to_salaFragment,
                    bundle
                )
            },
            onCancelarClick = { cita ->
                viewModel.cancelar(cita)
                Log.i("TelemedicinaLogger", "Cita cancelada: $cita")
            },
            onReagendarClick = { cita ->
                val bundle = Bundle().apply {
                    putString("id", cita.id)
                    putString("paciente", cita.paciente)
                    putString("modalidad", cita.modalidad)
                    putString("tratamiento", cita.tratamiento)
                    putString("fecha", cita.fecha)
                    putString("hora", cita.hora)
                }
                view.findNavController().navigate(
                    R.id.action_telemedicinaFragment_to_agendarCitasFragment,
                    bundle
                )


            }
        )

        binding.citaList.adapter = adapter

        viewModel.citas.observe(viewLifecycleOwner) { allCitas ->
            val telemedicinaCitas = allCitas
                .filter { it.modalidad == "Telemedicina" && !it.disponible }
                .sortedBy { it.fecha }

            adapter.data = telemedicinaCitas
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

