package com.example.movildev.fragments

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movildev.R
import com.example.movildev.databinding.FragmentEditarUsuariosBinding
import com.example.movildev.model.Usuario
import com.example.movildev.viewmodels.UsuarioViewModel

class EditarUsuariosFragment : Fragment() {

    private var _binding: FragmentEditarUsuariosBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UsuarioViewModel
    private val args: EditarUsuariosFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditarUsuariosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[UsuarioViewModel::class.java]

        configurarSpinner()
        configurarDatePicker()

        val usuarioId = args.usuarioId
        if (usuarioId != -1) {            // Modo edición
            viewModel.obtenerUsuarioPorId(usuarioId).observe(viewLifecycleOwner) { u ->
                u?.let { pintarUsuario(it) }
            }
        }

        binding.btnGuardar.setOnClickListener {
            val usuario = construirUsuario(usuarioId)

            if (usuarioId == -1) viewModel.agregarUsuario(usuario)
            else                 viewModel.actualizarUsuario(usuario)

            Toast.makeText(
                requireContext(),
                if (usuarioId == -1)
                    getString(R.string.usuario_creado)   // en strings.xml
                else
                    getString(R.string.usuario_actualizado),
                Toast.LENGTH_SHORT
            ).show()

            findNavController().popBackStack()           // después del Toast
        }

        binding.btnCancelar.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    /* ---------- helpers ---------- */

    private fun configurarSpinner() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.tipo_documento_array,
            android.R.layout.simple_spinner_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerDocumento.adapter = it
        }
    }

    private fun configurarDatePicker() {
        binding.inputFecha.setOnClickListener {
            val cal = Calendar.getInstance()
            val dlg = DatePickerDialog(
                requireContext(),
                { _, y, m, d -> binding.inputFecha.setText("%02d/%02d/%04d".format(d, m + 1, y)) },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            dlg.show()
        }
    }

    private fun pintarUsuario(u: Usuario) = with(binding) {
        inputNombre.setText(u.nombre)
        spinnerDocumento.setSelection(
            (spinnerDocumento.adapter as ArrayAdapter<String>).getPosition(u.tipoDocumento)
        )
        inputNumero.setText(u.documento)
        inputFecha.setText(u.fechaNacimiento)
        inputEmail.setText(u.email)
    }

    private fun construirUsuario(idAntiguo: Int) = Usuario(
        id = if (idAntiguo == -1) generateNewId() else idAntiguo,
        nombre = binding.inputNombre.text.toString(),
        tipoDocumento = binding.spinnerDocumento.selectedItem as String,
        documento = binding.inputNumero.text.toString(),
        fechaNacimiento = binding.inputFecha.text.toString(),
        email = binding.inputEmail.text.toString(),
        nombrePersona = binding.inputNombre.text.toString(),
        telefono = TODO()
    )

    private fun generateNewId(): Int {
        val actual = viewModel.usuarios.value.orEmpty()
        return (actual.maxOfOrNull { it.id } ?: 0) + 1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}