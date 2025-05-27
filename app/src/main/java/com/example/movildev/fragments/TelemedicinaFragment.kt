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
import com.example.movildev.viewmodels.TelemedicinaViewModel

class TelemedicinaFragment : Fragment() {

    private var _binding: FragmentTelemedicinaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TelemedicinaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTelemedicinaBinding.inflate(inflater, container, false)
        val view = binding.root

        //ViewModelProvider ensures that a new object only gets created if one doesn't exist already
        viewModel = ViewModelProvider(this).get(TelemedicinaViewModel::class.java)

        val adapter = TelemedicinaItemAdapter(
            onAccederClick = { cita ->
                val action = TelemedicinaFragmentDirections
                    .actionTelemedicinaFragmentToSalaFragment(viewModel.cita)
                view.findNavController().navigate(action)
            },
            onCancelarClick = { cita ->
                viewModel.cancelar(cita)
                Log.i("TelemedicinaLogger", "cancelar: $cita")
            }
        )
        binding.citaList.adapter = adapter

        viewModel.citas.observe(viewLifecycleOwner) { allCitas ->
            Log.d("TelemedicinaFragment", "Citas: $allCitas")
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