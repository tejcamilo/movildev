package com.example.movildev.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.model.Cita
import com.example.movildev.R
import com.example.movildev.adapters.CitaItemAdapter.CitaItemViewHolder

class TelemedicinaItemAdapter(
    private val onAccederClick: (Cita) -> Unit,
    private val onCancelarClick: (Cita) -> Unit,
    private val onReagendarClick: (Cita) -> Unit
) : RecyclerView.Adapter<TelemedicinaItemAdapter.TelemedicinaItemViewHolder>() {

    var data = listOf<Cita>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = TelemedicinaItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TelemedicinaItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, onAccederClick, onCancelarClick, onReagendarClick)
    }

    class TelemedicinaItemViewHolder(val rootView: FrameLayout) : RecyclerView.ViewHolder(rootView) {

        val fechaCita = rootView.findViewById<TextView>(R.id.detalle_cita)
        val pacienteCita = rootView.findViewById<TextView>(R.id.nombre_paciente)
        val profesionalCita = rootView.findViewById<TextView>(R.id.detalle_profesional)
        val tratamientoCita = rootView.findViewById<TextView>(R.id.detalles_tratamiento)

        companion object {
            fun inflateFrom(parent: ViewGroup) : TelemedicinaItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.cita_item, parent, false) as FrameLayout
                return TelemedicinaItemViewHolder(view)
            }
        }
        fun bind(item: Cita, onAccederClick: (Cita) -> Unit,
                 onReagendarClick: (Cita) -> Unit,
                 onCancelarClick: (Cita) -> Unit) {
            fechaCita.text = "${item.fecha} - ${item.hora}"
            pacienteCita.text = item.paciente
            profesionalCita.text = "Cathalina"
            tratamientoCita.text = item.tratamiento


            Log.i("TelemedicinaLogger", "bind: $item")

            val accederBtn = rootView.findViewById<Button>(R.id.acceder_btn)
            accederBtn.visibility = if (item.hora == "10:00 AM") View.VISIBLE else View.GONE
            accederBtn.setOnClickListener { onAccederClick(item) }

            rootView.findViewById<Button>(R.id.reprogramar_btn).setOnClickListener {
                androidx.appcompat.app.AlertDialog.Builder(rootView.context)
                    .setTitle("Cancelar cita")
                    .setMessage("¿Desea caneclar la cita?")
                    .setPositiveButton("OK") { _, _ ->
                        onReagendarClick(item)
                    }
                    .show()

            }

            rootView.findViewById<Button>(R.id.cancelar_btn).setOnClickListener {
                androidx.appcompat.app.AlertDialog.Builder(rootView.context)
                    .setTitle("Reprogramar cita")
                    .setMessage("¿Desea reprogramar la cita?")
                    .setPositiveButton("OK") { _, _ ->
                        onCancelarClick(item.copy(disponible = true))
                    }
                    .show()
            }
        }
    }
}

