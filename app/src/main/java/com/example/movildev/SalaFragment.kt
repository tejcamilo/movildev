package com.example.movildev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movildev.databinding.FragmentSalaBinding
import com.example.movildev.viewmodel.SalaViewModel
import com.example.movildev.viewmodel.SalaViewModelFactory
import android.util.Log

class SalaFragment : Fragment() {
    private var _binding: FragmentSalaBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: SalaViewModel
    lateinit var viewModelFactory: SalaViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSalaBinding.inflate(inflater, container, false)
        val view = binding.root

        val cita = SalaFragmentArgs.fromBundle(requireArguments()).cita // recibir dato desde Telemedicina
        Log.i("Cita", cita)
        viewModelFactory = SalaViewModelFactory(cita)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(SalaViewModel::class.java)

        binding.ingresarLlamadaBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_salaFragment_to_llamadaFragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}