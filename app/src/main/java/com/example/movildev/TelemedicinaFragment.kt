package com.example.movildev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movildev.databinding.FragmentTelemedicinaBinding

class TelemedicinaFragment : Fragment() {
    private var _binding: FragmentTelemedicinaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTelemedicinaBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.accederBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_telemedicinaFragment_to_salaFragment)
        }

        val frame1 = view.findViewById<LinearLayout>(R.id.frame1)
        frame1.setOnClickListener {
            val text = "El acceso a la cita estará disponible 5 minutos antes de la hora programada"
            Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}