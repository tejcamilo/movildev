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

class PerfilFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        // modificar iconos y texto del toolbar
        val header = view.findViewById<LinearLayout>(R.id.header)
        // Adjust padding for punchhole displays
        ViewCompat.setOnApplyWindowInsetsListener(header) { view, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            view.setPadding(view.paddingLeft, statusBarHeight, view.paddingRight, view.paddingBottom)
            insets
        }
        val backBtn = header.findViewById<ImageButton>(R.id.back_btn)
        val toolbarIcon = header.findViewById<ImageView>(R.id.toolbar_icon)
        val title = header.findViewById<TextView>(R.id.title)

        backBtn.setImageResource(R.drawable.back_arrow)
        toolbarIcon.setImageResource(R.drawable.profile)
        title.text = "Perfil"

        return view
    }
}