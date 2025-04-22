package com.example.fisiocare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fisiocare.ui.theme.FisioCareTheme

import com.google.android.material.bottomnavigation.LabelVisibilityMode

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.factura_main)

    val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
    bottomNav.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

}
