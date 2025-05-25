package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
            view.findNavController().navigate(R.id.action_citasFragment_to_telemedicinaFragment)
        }

        val adapter = CitaItemAdapter()
        binding.citaList.adapter = adapter

        viewModel.citas.observe(viewLifecycleOwner) {
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