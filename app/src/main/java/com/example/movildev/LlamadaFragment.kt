package com.example.movildev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class LlamadaFragment : Fragment () {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_llamada, container, false)
        val backButton = view.findViewById<ImageButton>(R.id.back_btn)

        backButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_llamadaFragment_to_salaFragment)
        }

        return view
    }
}
