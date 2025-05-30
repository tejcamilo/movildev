package com.example.movildev.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.R
import com.example.movildev.model.Cita
import com.example.movildev.repositories.CitaRepository
import java.io.File
import java.io.FileOutputStream
import java.text.NumberFormat
import java.util.Locale

class CitaAdapter(
    private var citas: List<Cita>,
    private val onReagendar: (Cita) -> Unit,
    private val onCancelar: (Cita) -> Unit
) : RecyclerView.Adapter<CitaAdapter.CitaViewHolder>() {

    private var citasFiltradas: List<Cita> = citas.toList()

    inner class CitaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombrePaciente: TextView = view.findViewById(R.id.nombrePacienteCitaText)
        val modalidadCita: TextView = view.findViewById(R.id.modalidadText)
        val tratamiento: TextView = view.findViewById(R.id.tratamientoText)
        val fechaText: TextView = view.findViewById(R.id.fechaText)
        val btnReagendar: Button = view.findViewById(R.id.btnReagendar)
        val btnCancelar: Button = view.findViewById(R.id.btnCancelar)
        val btnFactura: Button = view
            .findViewById(R.id.btnFactura)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cita_card, parent, false)
        return CitaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val cita = citasFiltradas[position]

        holder.nombrePaciente.text = cita.paciente
        holder.modalidadCita.text = cita.modalidad
        holder.tratamiento.text = cita.tratamiento
        holder.fechaText.text = "${cita.fecha} - ${cita.hora}"

        holder.btnReagendar.setOnClickListener { onReagendar(cita) }
        holder.btnCancelar.setOnClickListener { onCancelar(cita) }
    }

    override fun getItemCount(): Int = citasFiltradas.size

    fun updateData(newList: List<Cita>) {
        citas = newList
        citasFiltradas = newList
        notifyDataSetChanged()
    }

    fun filtrarPorNombre(query: String) {
        val filtro = query.trim()
        citasFiltradas = if (filtro.isEmpty()) {
            citas
        } else {
            citas.filter {
                it.paciente.contains(filtro, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }
}

//    fun bind(item: Cita, onCancelarClick: (Cita) -> Unit) {
//
//
//        val cancelarBtn = rootView.findViewById<Button>(R.id.cancelar_btn)
//        cancelarBtn.setOnClickListener {
//            androidx.appcompat.app.AlertDialog.Builder(rootView.context)
//                .setTitle("Cancelar cita")
//                .setMessage("¿Desea cancelar la cita?")
//                .setPositiveButton("OK") { _, _ ->
//                    onCancelarClick(item.copy(disponible = true))
//                }
//                .show()
//        }
//    }
//}





