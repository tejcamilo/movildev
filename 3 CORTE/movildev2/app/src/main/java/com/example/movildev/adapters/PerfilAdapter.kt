package com.example.movildev.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.databinding.ItemDatoPerfilBinding

data class DatoPerfil(
    val etiqueta: String,
    var valor: String,
    val campo: CampoEditable
)

enum class CampoEditable { NOMBRE, DOCUMENTO, CORREO, TELEFONO }

class PerfilAdapter(
    private val datos: MutableList<DatoPerfil>,
    private val onEdit: (CampoEditable, String) -> Unit
) : RecyclerView.Adapter<PerfilAdapter.VH>() {

    inner class VH(val b: ItemDatoPerfilBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemDatoPerfilBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) = with(holder.b) {
        val item = datos[position]
        txtEtiqueta.text = item.etiqueta
        txtValor.text  = item.valor

        // Solo permiten edición Nombre y Teléfono
        val editable = item.campo == CampoEditable.NOMBRE ||
                item.campo == CampoEditable.TELEFONO

        btnEditar.visibility   = if (editable) View.VISIBLE else View.GONE
        btnEditar.isEnabled    = editable
        root.isClickable       = editable          // evita que parezca pulsable
        root.isFocusable       = editable

        if (editable) {
            btnEditar.setOnClickListener { onEdit(item.campo, item.valor) }
        } else {
            btnEditar.setOnClickListener(null)
        }
    }

    override fun getItemCount() = datos.size

    fun actualizarCampo(campo: CampoEditable, nuevoValor: String) {
        val index = datos.indexOfFirst { it.campo == campo }
        if (index != -1) {
            datos[index].valor = nuevoValor
            notifyItemChanged(index)
        }
    }
}

