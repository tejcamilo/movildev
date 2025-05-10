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
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

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