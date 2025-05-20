package com.example.citasfisiocare

import androidx.recyclerview.widget.RecyclerView
import android. view. View
import android.widget.Button
import android. view. ViewGroup
import android.widget.TextView
import android. view. LayoutInflater


class CitaAdapter(
    private val citas: List<String>,
    private val onAgendarClick: (String) -> Unit
) : RecyclerView.Adapter<CitaAdapter.CitaViewHolder>() {

    class CitaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textoCita: TextView = view.findViewById(R.id.tv_cita_info)
        val botonAgendar: Button = view.findViewById(R.id.btn_agendar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CitaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val cita = citas[position]
        holder.textoCita.text = cita
        holder.botonAgendar.setOnClickListener {
            onAgendarClick(cita)
        }
    }

    override fun getItemCount(): Int = citas.size
}