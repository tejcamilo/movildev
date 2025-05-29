package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movildev.R
import com.example.movildev.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnLogin.setOnClickListener {
            val username = binding.user.text.toString()
            val password = binding.password.text.toString()
            if (username.isBlank() || password.isBlank()) {
                Toast.makeText(requireContext(), "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show()
            } else if (username == "user" && password == "user") {
                view.findNavController().navigate(R.id.action_loginFragment_to_inicioFragment)
            } else {
                Toast.makeText(requireContext(), "Datos inválidos", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}