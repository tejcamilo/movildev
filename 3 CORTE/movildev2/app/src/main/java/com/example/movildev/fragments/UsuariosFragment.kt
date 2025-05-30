package com.example.movildev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movildev.adapters.UsuarioItemAdapter
import com.example.movildev.databinding.FragmentUsuariosLayoutBinding
import com.example.movildev.model.Usuario
import com.example.movildev.viewmodels.UsuarioViewModel

class UsuariosFragment : Fragment() {

    private var _binding: FragmentUsuariosLayoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: UsuarioViewModel
    private lateinit var adapter: UsuarioItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsuariosLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Instancia del ViewModel
        viewModel = ViewModelProvider(this)[UsuarioViewModel::class.java]

        // Configura el adapter
        adapter = UsuarioItemAdapter(
            onEditarClick = { usuario: Usuario ->
                val action = UsuariosFragmentDirections
                    .actionUsuariosFragmentToFormularioUsuarioFragment(usuario.id)
                findNavController().navigate(action)
            },
            onEliminarClick = { usuario: Usuario ->
                viewModel.eliminarUsuario(usuario)
            },
            onVerClick = { usuario: Usuario ->
                val action = UsuariosFragmentDirections
                    .actionUsuariosFragmentToDetalleUsuarioFragment(usuario.id)
                findNavController().navigate(action)
            }
        )

        // RecyclerView
        binding.rvUsuarios.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUsuarios.adapter = adapter

        // Observa la lista de usuarios y actualiza el adapter
        viewModel.usuarios.observe(viewLifecycleOwner) { lista ->
            adapter.data = lista
        }

        // Filtrado por texto en la búsqueda
        binding.inputBuscar.doOnTextChanged { text, _, _, _ ->
            // Aquí podrías implementar filterable en tu adapter
            // Por simplicidad, mostramos todo si el campo está vacío
            if (text.isNullOrBlank()) {
                adapter.data = viewModel.usuarios.value.orEmpty()
            } else {
                val filtrados = viewModel.usuarios.value.orEmpty()
                    .filter { it.nombre.contains(text, ignoreCase = true) }
                adapter.data = filtrados
            }
        }

        // Navega al formulario para crear un nuevo usuario
        binding.fabAgregar.setOnClickListener {
            findNavController().navigate(
                UsuariosFragmentDirections.actionUsuariosFragmentToFormularioUsuarioFragment(-1)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
