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

class TelemedicinaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_telemedicina, container, false)
        val startButton = view.findViewById<Button>(R.id.acceder_btn)

        // modificar iconos y texto del toolbar
        val header = view.findViewById<LinearLayout>(R.id.header)
        val backBtn = header.findViewById<ImageButton>(R.id.back_btn)
        val toolbarIcon = header.findViewById<ImageView>(R.id.toolbar_icon)
        val title = header.findViewById<TextView>(R.id.title)

        backBtn.setImageResource(R.drawable.back_arrow)
        toolbarIcon.setImageResource(R.drawable.telemedicina)
        title.text = "Telemedicina"

        startButton.setOnClickListener {
           view.findNavController()
               .navigate(R.id.action_telemedicinaFragment_to_salaFragment)
        }
        val frame1 = view.findViewById<LinearLayout>(R.id.frame1)
        frame1.setOnClickListener {
            val text = "El acceso a la cita estará disponible 5 minutos antes de la hora programada"
            Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
        }
        return view
    }
}