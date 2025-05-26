package com.example.movildev.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.R
import com.example.movildev.model.Factura
import com.example.movildev.repositories.FacturaRepository
import java.text.NumberFormat
import java.util.Locale

class FacturaAdapter(
    private var facturas: List<Factura>,
    private val onModificar: (Factura) -> Unit,
    private val onEliminar: (Factura) -> Unit
) : RecyclerView.Adapter<FacturaAdapter.FacturaViewHolder>() {

    inner class FacturaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombrePaciente: TextView = view.findViewById(R.id.nombrePacienteText)
        val valorCita: TextView = view.findViewById(R.id.valorCitaText)
        val tratamiento: TextView = view.findViewById(R.id.tratamiento)
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
        val formatoPesos = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        formatoPesos.maximumFractionDigits = 0

        holder.nombrePaciente.text = factura.paciente
        holder.valorCita.text = formatoPesos.format(factura.valor)
        holder.tratamiento.text = factura.tratamiento
        holder.fechaText.text = factura.fecha
        holder.horaText.text = factura.hora

        holder.btnModificar.setOnClickListener { onModificar(factura) }
        holder.btnEliminar.setOnClickListener { onEliminar(factura) }
    }

    override fun getItemCount(): Int = facturas.size

    fun updateData(newList: List<Factura>) {
        facturas = newList
        notifyDataSetChanged()
    }
}

