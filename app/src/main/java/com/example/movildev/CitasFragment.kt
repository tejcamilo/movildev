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
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class CitasFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_citas, container, false)

        // modificar iconos y texto del toolbar
        val header = view.findViewById<LinearLayout>(R.id.header)
        val backBtn = header.findViewById<ImageButton>(R.id.back_btn)
        val toolbarIcon = header.findViewById<ImageView>(R.id.toolbar_icon)
        val title = header.findViewById<TextView>(R.id.title)

        backBtn.setImageResource(R.drawable.back_arrow)
        toolbarIcon.setImageResource(R.drawable.calendar)
        title.text = "Citas"

        return view
    }
}