package com.example.movildev.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.R
import com.example.movildev.model.Factura

class FacturaAdapter(
    private val onModificar: (Factura) -> Unit,
    private val onEliminar: (Factura) -> Unit
) : RecyclerView.Adapter<FacturaAdapter.FacturaViewHolder>() {

    private var facturas: MutableList<Factura> = mutableListOf()

    inner class FacturaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombrePaciente: TextView = view.findViewById(R.id.nombrePacienteText)
        val valorCita: TextView = view.findViewById(R.id.valorCitaText)
        val fechaText: TextView = view.findViewById(R.id.fechaText)
        val horaText: TextView = view.findViewById(R.id.horaText)
        val btnModificar: Button = view.findViewById(R.id.btnModificar)
        val btnEliminar: Button = view.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacturaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.factura_tm, parent, false)
        return FacturaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacturaViewHolder, position: Int) {
        val factura = facturas[position]

        holder.nombrePaciente.text = factura.paciente
        holder.valorCita.text = "$${factura.valor}"
        holder.fechaText.text = factura.fecha
        holder.horaText.text = factura.hora

        holder.btnModificar.setOnClickListener { onModificar(factura) }
        holder.btnEliminar.setOnClickListener { onEliminar(factura) }
    }

    override fun getItemCount(): Int = facturas.size

    fun updateData(nuevasFacturas: List<Factura>) {
        facturas.clear()
        facturas.addAll(nuevasFacturas)
        notifyDataSetChanged()
    }
}

