package com.example.myapplication

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.ui.theme.MyApplicationTheme

RecyclerView recyclerView = findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(this));

List<Cita> listaCitas = new ArrayList<>();
listaCitas.add(new Cita("25/04/25 09:45 AM", "Terapia", "Cathalina Cañón", "Presencial"));
listaCitas.add(new Cita("26/04/25 10:00 AM", "Consulta", "Carlos Pérez", "Virtual"));
// Agrega más citas...

CitaAdapter adapter = new CitaAdapter(listaCitas);
recyclerView.setAdapter(adapter);




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}