package com.example.movildev.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.databinding.UsuarioItemBinding
import com.example.movildev.model.Usuario


class UsuarioItemAdapter(
    private val onEditarClick: (Usuario) -> Unit,
    private val onEliminarClick: (Usuario) -> Unit,
    private val onVerClick: (Usuario) -> Unit
) : RecyclerView.Adapter<UsuarioItemAdapter.ViewHolder>() {

    var data = listOf<Usuario>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: UsuarioItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(usuario: Usuario) {
            // Asignamos textos según IDs de tu XML
            binding.tvNombreUsuario.text = usuario.nombre
            binding.tvNumeroDocumento.text = usuario.documento
            binding.tvNombrePersona.text = usuario.nombrePersona

            // Listener Editar
            binding.btnEditar.setOnClickListener {
                onEditarClick(usuario)
            }
            // Listener Ver
            binding.btnVer.setOnClickListener {
                onVerClick(usuario)
            }
            // Listener Eliminar con confirmación
            binding.btnEliminar.setOnClickListener {
                AlertDialog.Builder(binding.root.context)
                    .setTitle("Eliminar usuario")
                    .setMessage("¿Deseas eliminar a ${usuario.nombrePersona}?")
                    .setPositiveButton("Sí") { _, _ ->
                        onEliminarClick(usuario)
                    }
                    .setNegativeButton("No", null)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UsuarioItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
