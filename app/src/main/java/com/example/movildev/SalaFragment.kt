package com.example.movildev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class SalaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sala, container, false)
        val startButton = view.findViewById<ImageButton>(R.id.ingresar_llamada_btn)

        startButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_salaFragment_to_llamadaFragment)
        }
        return view
    }
}