package com.example.movildev.fragments

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.movildev.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var citasRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("findme", "App started")

        // Initialize Firebase Realtime Database
        val database = FirebaseDatabase.getInstance()
        citasRef = database.getReference("citas")

        // Adjust padding for punchhole displays
        val header = findViewById<LinearLayout>(R.id.header)
        ViewCompat.setOnApplyWindowInsetsListener(header) { view, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            view.setPadding(view.paddingLeft, statusBarHeight, view.paddingRight, view.paddingBottom)
            insets
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavView.setupWithNavController(navController)

        val backBtn = findViewById<ImageButton>(R.id.back_btn)
        val toolbarIcon = findViewById<ImageView>(R.id.toolbar_icon)
        val title = findViewById<TextView>(R.id.title)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.consultarFacturasFragment -> {
                    title.text = "Facturación"
                    toolbarIcon.setImageResource(R.drawable.ic_factura)
                }
                R.id.crearFacturaFragment -> {
                    title.text = "Facturación"
                    toolbarIcon.setImageResource(R.drawable.ic_factura)
                }
                R.id.facturaElectronicaFragment -> {
                    title.text = "Facturación"
                    toolbarIcon.setImageResource(R.drawable.ic_factura)
                }
                else -> {
                    title.text = "FisioCare"
                    toolbarIcon.setImageResource(R.drawable.placeholder_icon)
                }
            }
        }


        backBtn.setOnClickListener {
            navController.navigateUp() // Navigate back when the back button is clicked
        }
    }
}