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

    private val onAccederClick: (Cita) -> Unit,
    private val onCancelarClick: (Cita) -> Unit,
    private val onReagendarClick: (Cita) -> Unit)
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
        holder.bind(item, onAccederClick, onCancelarClick, onReagendarClick)
    }

    class CitaItemViewHolder(val rootView : FrameLayout) : RecyclerView.ViewHolder(rootView) {

        val fechaCita = rootView.findViewById<TextView>(R.id.detalle_cita)
        val pacienteCita = rootView.findViewById<TextView>(R.id.nombre_paciente)
        val profesionalCita = rootView.findViewById<TextView>(R.id.detalle_profesional)
        val tratamientoCita = rootView.findViewById<TextView>(R.id.detalles_tratamiento)

        companion object {
            fun inflateFrom(parent: ViewGroup) : CitaItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.cita_item, parent, false) as FrameLayout
                return CitaItemViewHolder(view)
            }
        }
        fun bind(item: Cita, onAccederClick: (Cita) -> Unit,
                 onReagendarClick: (Cita) -> Unit,
                 onCancelarClick: (Cita) -> Unit) {
            fechaCita.text = "${item.fecha} - ${item.hora}"
            pacienteCita.text = item.paciente
            profesionalCita.text = "Cathalina"
            tratamientoCita.text = item.tratamiento


            Log.i("CitaLogger", "bind: $item")

            val accederBtn = rootView.findViewById<Button>(R.id.acceder_btn)
            /*
            val params = accederBtn.layoutParams as FrameLayout.LayoutParams
            val topMarginDp = 184
            val scale = accederBtn.context.resources.displayMetrics.density
            params.topMargin = (topMarginDp * scale + 0.5f).toInt()
            accederBtn.layoutParams = params
             */
            accederBtn.visibility = View.GONE

            rootView.findViewById<Button>(R.id.reprogramar_btn).setOnClickListener {
                onReagendarClick(item)
            }

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
            val reagendarBtn = rootView.findViewById<Button>(R.id.btnReagendar)
            cancelarBtn.setOnClickListener {
                androidx.appcompat.app.AlertDialog.Builder(rootView.context)
                    .setTitle("Reagendar cita")
                    .setMessage("¿Desea reagendar la cita?")
                    .setPositiveButton("OK") { _, _ ->
                        onReagendarClick(item.copy(disponible = true))
                    }
                    .show()
            }
        }
    }
}