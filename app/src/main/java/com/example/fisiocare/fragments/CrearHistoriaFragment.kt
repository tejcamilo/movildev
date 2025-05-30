package com.example.fisiocare.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fisiocare.Model.HistoriaClinica
import com.example.fisiocare.repository.HistoriaClinicaRepositorySingleton
import com.example.fisiocare.viewmodel.CrearHistoriaViewModel
import com.example.fisiocare.viewmodel.CrearHistoriaViewModelFactory
import com.example.fisiocare.R

class CrearHistoriaFragment : Fragment() {

    private lateinit var nombreEditText: EditText
    private lateinit var documentoEditText: EditText
    private lateinit var telefonoEditText: EditText
    private lateinit var epsEditText: EditText
    private lateinit var motivoEditText: EditText


    private lateinit var guardarButton: Button
    private lateinit var flechaAtras: ImageView

    private lateinit var viewModel: CrearHistoriaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_crear_historia, container, false)

        // Inicializar el ViewModel con el repositorio singleton
        viewModel = ViewModelProvider(
            this,
            CrearHistoriaViewModelFactory(HistoriaClinicaRepositorySingleton.get())
        )[CrearHistoriaViewModel::class.java]

        // Referencias a los EditText y botones
        nombreEditText = view.findViewById(R.id.etNombreCompleto)
        documentoEditText = view.findViewById(R.id.etDocumento)
        telefonoEditText = view.findViewById(R.id.etTelefono)
        motivoEditText = view.findViewById(R.id.etMotivoConsulta)
        epsEditText = view.findViewById(R.id.etEps)


        guardarButton = view.findViewById(R.id.botonGuardar)
        flechaAtras = view.findViewById(R.id.flechaatras)

        // Acción del botón guardar
        guardarButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val telefono = documentoEditText.text.toString()
            val eps = epsEditText.text.toString()
            val motivo = motivoEditText.text.toString() // asumiendo que tienes este EditText
            val documento = documentoEditText.text.toString()

            viewModel.insertarHistoria(nombre, telefono, eps, motivo, documento)

            Toast.makeText(requireContext(), "Historia guardada", Toast.LENGTH_SHORT).show()
        }

        // Acción del ícono de volver
        flechaAtras.setOnClickListener {
            findNavController().navigateUp()
        }

        return view
    }
}
