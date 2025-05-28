package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movildev.R
import com.example.movildev.databinding.FragmentLandCitasBinding

class LandCitasFragment : Fragment () {
    private var _binding: FragmentLandCitasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandCitasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.navConsultarCitas.setOnClickListener {
            view.findNavController().navigate(R.id.action_citasFragment_to_agendarCitasFragment)
        }

        binding.navAgendarCitas.setOnClickListener {
            view.findNavController().navigate(R.id.action_citasFragment_to_agendarCitasFragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
