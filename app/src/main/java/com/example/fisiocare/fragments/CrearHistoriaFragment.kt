package com.example.fisiocare.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.fisiocare.Model.HistoriaClinica
import com.example.fisiocare.viewmodel.HistoriaClinicaViewModel
import com.example.fisiocare.viewmodel.HistoriaClinicaViewModelFactory
import com.project.fisiocare.databinding.FragmentCrearHistoriaBinding
class CrearHistoriaFragment : Fragment() {

    private var _binding: FragmentCrearHistoriaBinding? = null
    private val binding get() = _binding!!
    private lateinit var historiaViewModel: HistoriaClinicaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrearHistoriaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val factory = HistoriaClinicaViewModelFactory(requireContext())
        historiaViewModel = ViewModelProvider(this, factory)[HistoriaClinicaViewModel::class.java]
        super.onViewCreated(view, savedInstanceState)

        binding.btnGuardarHistoria.setOnClickListener {
            guardarHistoriaClinica()
        }
    }

    private fun guardarHistoriaClinica() {
        val nombre = binding.etNombreCompleto.text.toString().trim()
        val documento = binding.etDocumento.text.toString().trim()
        val telefono = binding.etTelefono.text.toString().trim()
        val correo = binding.etCorreo.text.toString().trim()
        val eps = binding.etEps.text.toString().trim()
        val antecedentes = binding.etAntecedentes.text.toString().trim()

        if (nombre.isEmpty() || documento.isEmpty() || telefono.isEmpty() || correo.isEmpty() || eps.isEmpty()) {
            Toast.makeText(requireContext(), "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val historia = HistoriaClinica(
            nombreCompleto = nombre,
            documento = documento,
            telefono = telefono,
            correo = correo,
            eps = eps,
            antecedentes = antecedentes
        )

        historiaViewModel.insertar(historia)
        Toast.makeText(requireContext(), "Historia clínica guardada", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
