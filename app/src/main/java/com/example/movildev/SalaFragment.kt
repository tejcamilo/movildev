package com.example.movildev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.movildev.databinding.FragmentSalaBinding
import com.example.movildev.viewmodel.SalaViewModel
import com.example.movildev.viewmodel.SalaViewModelFactory

class SalaFragment : Fragment() {
    private var _binding: FragmentSalaBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: SalaViewModel
    lateinit var viewModelFactory: SalaViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSalaBinding.inflate(inflater, container, false)
        val view = binding.root

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