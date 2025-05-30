package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.movildev.databinding.FragmentDetalleUsuarioBinding
import com.example.movildev.viewmodels.UsuarioViewModel

class DetalleUsuarioFragment : Fragment() {

    private var _binding: FragmentDetalleUsuarioBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: UsuarioViewModel
    private val args: DetalleUsuarioFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[UsuarioViewModel::class.java]

        // Observa el usuario indicado por ID
        viewModel.obtenerUsuarioPorId(args.usuarioId).observe(viewLifecycleOwner) { usuario ->
            usuario?.let {
                binding.tvDetalleNombre.text       = it.nombre
                binding.tvDetalleTipoDoc.text      = it.tipoDocumento
                binding.tvDetalleNumeroDoc.text    = it.documento
                binding.tvDetalleFechaNac.text     = it.fechaNacimiento
                binding.tvDetalleEmail.text        = it.email
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
