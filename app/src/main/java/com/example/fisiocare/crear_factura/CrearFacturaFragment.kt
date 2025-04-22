package com.example.fisiocare.crear_factura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fisiocare.databinding.FragmentCrearFacturaBinding
import com.example.fisiocare.repositories.FacturaRepository
import com.example.fisiocare.viewmodels.CrearFacturaViewModel
import com.example.fisiocare.viewmodels.CrearFacturaViewModelFactory

class CrearFacturaFragment : Fragment() {

    private var _binding: FragmentCrearFacturaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CrearFacturaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrearFacturaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewModel con Factory manual
        val repository = FacturaRepository()
        val factory = CrearFacturaViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[CrearFacturaViewModel::class.java]

        // Navegación con flecha atrás
        binding.flechaatras.setOnClickListener {
            findNavController().navigate(R.id.action_crearFacturaFragment_to_mainFacturaFragment)
        }

        // Ejemplo: guardar factura
        binding.botonGuardar.setOnClickListener {
            viewModel.guardarFactura(
                cliente = "Cliente demo",
                tratamiento = "Fisioterapia",
                valor = 150.0
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

