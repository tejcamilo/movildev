package com.example.fisiocare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fisiocare.databinding.FragmentConsultarHistoriaBinding


class HistoriaClinicaFragment : Fragment() {

    private var _binding: FragmentConsultarHistoriaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConsultarHistoriaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón flecha atrás
        binding.flechaatras.setOnClickListener {
            // Navegar hacia atrás o cerrar fragmento
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        // Botones en card 2
        binding.btnDescargar2.setOnClickListener {
            // Acción para descargar datos de la historia clínica 2
        }

        binding.btnEditar2.setOnClickListener {
            // Acción para editar historia clínica 2
        }

        // Si quieres manejar botones similares en card1 (sin id)
        // puedes buscarlos con findViewById o darles id en XML y hacer binding.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
