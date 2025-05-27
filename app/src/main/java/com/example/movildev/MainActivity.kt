package com.example.movildev

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.movildev.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d("findme", "App started")

        // Adjust padding for punchhole displays
        ViewCompat.setOnApplyWindowInsetsListener(binding.header) { view0, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            view0.setPadding(
                view0.paddingLeft,
                statusBarHeight,
                view0.paddingRight,
                view0.paddingBottom
            )
            insets
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNav0.gotoInicio.setOnClickListener {
            navController.navigate(R.id.inicioFragment)
        }

        binding.bottomNav0.gotoCitas.setOnClickListener {
            navController.navigate(R.id.landCitasFragment)
        }

        binding.bottomNav0.gotoHistoria.setOnClickListener {
            navController.navigate(R.id.historiaFragment)
        }

        binding.bottomNav0.gotoPerfil.setOnClickListener {
            navController.navigate(R.id.perfilFragment)
        }


        navController.addOnDestinationChangedListener { _, destination, arguments ->
            val iconResId = arguments?.getInt("icon") ?: R.drawable.placeholder_icon
            binding.title.text = destination.label
            binding.toolbarIcon.setImageResource(iconResId)
        }

        binding.backBtn.setOnClickListener {
            navController.navigateUp() // Navigate back when the back button is clicked
        }
    }
}