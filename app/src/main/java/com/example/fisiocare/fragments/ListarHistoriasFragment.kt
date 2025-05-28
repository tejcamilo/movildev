package com.example.fisiocare.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fisiocare.adapter.HistoriaAdapter
import com.example.fisiocare.viewmodel.HistoriaClinicaViewModel
import com.project.fisiocare.databinding.FragmentListarHistoriasBinding

class ListarHistoriasFragment : Fragment() {

    private var _binding: FragmentListarHistoriasBinding? = null
    private val binding get() = _binding!!
    private val historiaViewModel: HistoriaClinicaViewModel by viewModels {
        HistoriaClinicaViewModel.Factory(requireContext())
    }

    private lateinit var adapter: HistoriaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListarHistoriasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HistoriaAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        historiaViewModel.todasLasHistorias.observe(viewLifecycleOwner) { historias ->
            adapter.submitList(historias)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
