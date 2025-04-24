package com.example.myapplication

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CitaAdapter(private val citas: MutableList<Cita>) :
    RecyclerView.Adapter<CitaAdapter.ViewHolder?>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var fecha: TextView
        var tipo: TextView
        var doctor: TextView
        var modalidad: TextView

        init {
            fecha = itemView.findViewById<TextView?>(R.id.info_fecha)
            tipo = itemView.findViewById<TextView?>(R.id.info_terapia)
            doctor = itemView.findViewById<TextView?>(R.id.info_doctor)
            modalidad = itemView.findViewById<TextView?>(R.id.info_modalidad)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista: View =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cita = citas.get(position)
        holder.fecha.setText(cita.fecha)
        holder.tipo.setText(cita.tipo)
        holder.doctor.setText(cita.doctor)
        holder.modalidad.setText(cita.modalidad)
    }

    override fun getItemCount(): Int {
        return citas.size
    }
}
