package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movildev.R

class CitasFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_citas, container, false)


        val telemedicinaButton = view.findViewById<Button>(R.id.ir_telemedicina)
        telemedicinaButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_citasFragment_to_telemedicinaFragment)
        }

        return view
    }
}