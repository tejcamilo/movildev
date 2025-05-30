package com.example.movildev.fragments

import com.example.movildev.ChatActivity

import android.app.AlertDialog
import android.content.Intent          // ← nuevo
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movildev.R
import com.example.movildev.adapters.*
import com.example.movildev.databinding.FragmentPerfilBinding
import com.example.movildev.model.Usuario
import com.example.movildev.viewmodels.UsuarioViewModel

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: UsuarioViewModel
    private lateinit var adapter: PerfilAdapter
    private lateinit var usuarioActual: Usuario

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[UsuarioViewModel::class.java]

        // Para el ejemplo cogemos el primero de la lista (ajusta según tu lógica)
        usuarioActual = viewModel.usuarios.value?.firstOrNull()
            ?: throw IllegalStateException("No hay usuario cargado")

        configurarRecycler()

        /* ------------ acción del botón Chat ------------ */
        binding.btnHablarApi.setOnClickListener {
            val intent = Intent(requireContext(), ChatActivity::class.java)
            startActivity(intent)
        }
    }

    /* ---------------- private helpers ---------------- */

    private fun configurarRecycler() = with(binding.recyclerDatos) {
        layoutManager = LinearLayoutManager(requireContext())

        val items = mutableListOf(
            DatoPerfil(getString(R.string.nombre_usuario), usuarioActual.nombre, CampoEditable.NOMBRE),
            DatoPerfil(getString(R.string.documento), usuarioActual.documento, CampoEditable.DOCUMENTO),
            DatoPerfil(getString(R.string.correo), usuarioActual.email, CampoEditable.CORREO),
            DatoPerfil(getString(R.string.telefono), usuarioActual.telefono, CampoEditable.TELEFONO)
        )

        adapter = PerfilAdapter(items) { campo, valorActual ->
            mostrarDialogoEdicion(campo, valorActual)
        }.also { adapter = it }
    }

    private fun mostrarDialogoEdicion(campo: CampoEditable, valorActual: String) {
        val entrada = EditText(requireContext()).apply {
            setText(valorActual)
            inputType = when (campo) {
                CampoEditable.CORREO   -> InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                CampoEditable.TELEFONO -> InputType.TYPE_CLASS_PHONE
                else                   -> InputType.TYPE_CLASS_TEXT
            }
        }

        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.editar))
            .setView(entrada)
            .setPositiveButton(R.string.guardar) { _, _ ->
                val nuevo = entrada.text.toString()
                guardarCambios(campo, nuevo)
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun guardarCambios(campo: CampoEditable, nuevoValor: String) {
        usuarioActual = when (campo) {
            CampoEditable.NOMBRE    -> usuarioActual.copy(nombre = nuevoValor)
            CampoEditable.DOCUMENTO -> usuarioActual.copy(documento = nuevoValor)
            CampoEditable.CORREO    -> usuarioActual.copy(email = nuevoValor)
            CampoEditable.TELEFONO  -> usuarioActual.copy(telefono = nuevoValor)
        }
        viewModel.actualizarUsuario(usuarioActual)
        (adapter as PerfilAdapter).actualizarCampo(campo, nuevoValor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

