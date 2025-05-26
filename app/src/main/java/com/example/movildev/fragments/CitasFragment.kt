package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.movildev.R
import com.example.movildev.adapters.CitaItemAdapter
import com.example.movildev.databinding.FragmentCitasBinding
import com.example.movildev.viewmodels.TelemedicinaViewModel

class CitasFragment : Fragment() {

    private var _binding: FragmentCitasBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TelemedicinaViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCitasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.irTelemedicina.setOnClickListener {
            //view.findNavController().navigate(R.id.action_citasFragment_to_telemedicinaFragment)
            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("Popup Title")
                .setMessage("This is your popup message.")
                .setPositiveButton("OK") { dialog, _ ->
                    // Action after OK is clicked
                    view.findNavController().navigate(R.id.action_citasFragment_to_telemedicinaFragment)
                }
                .show()
        }

        val adapter = CitaItemAdapter()
        binding.citaList.adapter = adapter

        // PARA FILTRAR CITAS AGENDADAS
        var citasAgendadas = viewModel.getCitasAgendadas()

        citasAgendadas.observe(viewLifecycleOwner) {
            citasList ->
                adapter.data = citasList
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}