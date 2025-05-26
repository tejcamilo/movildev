package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movildev.R
import com.example.movildev.databinding.FragmentCitasBinding
import com.example.movildev.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.navHistoriaClinica.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicioFragment_to_historiaFragment)
        }

        binding.navCitas.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicioFragment_to_citasFragment)
        }

        binding.navFacturacion.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicioFragment_to_facturaFragment)
        }

        binding.navTelemedicina.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicioFragment_to_telemedicinaFragment)
        }

        binding.navTratamiento.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicioFragment_to_tratamientoFragment)
        }

        binding.navUsuarios.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicioFragment_to_usuariosFragment)
        }

        binding

        return view
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}