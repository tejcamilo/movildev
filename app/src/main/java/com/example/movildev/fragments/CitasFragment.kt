package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movildev.R
import com.example.movildev.databinding.FragmentCitasBinding
import com.example.movildev.model.CitaDatabase
import com.example.movildev.viewmodel.CitaViewModel
import com.example.movildev.viewmodel.CitaViewModelFactory

class CitasFragment : Fragment() {

    private var _binding: FragmentCitasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCitasBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = CitaDatabase.getInstance(application).citaDao
        val viewModelFactory = CitaViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CitaViewModel::class.java)
        binding.viewModel = viewModel

        binding.irTelemedicina.setOnClickListener {
            view.findNavController().navigate(R.id.action_citasFragment_to_telemedicinaFragment)
        }

        binding.irAddCitas.setOnClickListener {
            view.findNavController().navigate(R.id.action_citasFragment_to_addCitaFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}