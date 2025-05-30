package com.example.movildev.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.model.Cita
import com.example.movildev.R

class CitaItemAdapter(
    private val onCancelarClick: (Cita) -> Unit)
    : RecyclerView.Adapter<CitaItemAdapter.CitaItemViewHolder>() {
    var data = listOf<Cita>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int)
        : CitaItemViewHolder = CitaItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: CitaItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, onCancelarClick)
    }

    class CitaItemViewHolder(val rootView : FrameLayout) : RecyclerView.ViewHolder(rootView) {

        val fechaCita = rootView.findViewById<TextView>(R.id.detalle_cita)
        val tipoCita = rootView.findViewById<TextView>(R.id.detalle_tipo)
        val profesionalCita = rootView.findViewById<TextView>(R.id.detalle_profesional)
        val modalidadCita = rootView.findViewById<TextView>(R.id.detalle_modalidad)

        companion object {
            fun inflateFrom(parent: ViewGroup) : CitaItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.cita_item, parent, false) as FrameLayout
                return CitaItemViewHolder(view)
            }
        }
        fun bind(item: Cita, onCancelarClick: (Cita) -> Unit) {
            fechaCita.text = "${item.fecha} - ${item.hora}"
            tipoCita.text = item.tipo
            profesionalCita.text = item.profesional
            modalidadCita.text = item.modalidad

            Log.i("CitaLogger", "init: $item")

            val accederBtn = rootView.findViewById<Button>(R.id.acceder_btn)
            /*
            val params = accederBtn.layoutParams as FrameLayout.LayoutParams
            val topMarginDp = 184
            val scale = accederBtn.context.resources.displayMetrics.density
            params.topMargin = (topMarginDp * scale + 0.5f).toInt()
            accederBtn.layoutParams = params
             */
            accederBtn.visibility = View.GONE

            val cancelarBtn = rootView.findViewById<Button>(R.id.cancelar_btn)
            cancelarBtn.setOnClickListener {
                androidx.appcompat.app.AlertDialog.Builder(rootView.context)
                    .setTitle("Cancelar cita")
                    .setMessage("¿Desea cancelar la cita?")
                    .setPositiveButton("OK") { _, _ ->
                        onCancelarClick(item.copy(disponible = true))
                    }
                    .show()
            }
        }
    }
}