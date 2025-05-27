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

class TelemedicinaItemAdapter(
    private val onAccederClick: (Cita) -> Unit,
    private val onCancelarClick: (Cita) -> Unit)
        : RecyclerView.Adapter<TelemedicinaItemAdapter.TelemedicinaItemViewHolder>() {
    var data = listOf<Cita>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int)
            : TelemedicinaItemViewHolder = TelemedicinaItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TelemedicinaItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, onAccederClick, onCancelarClick)
    }

    class TelemedicinaItemViewHolder(val rootView : FrameLayout) : RecyclerView.ViewHolder(rootView) {

        val fechaCita = rootView.findViewById<TextView>(R.id.detalle_cita)
        val tipoCita = rootView.findViewById<TextView>(R.id.detalle_tipo)
        val profesionalCita = rootView.findViewById<TextView>(R.id.detalle_profesional)

        companion object {
            fun inflateFrom(parent: ViewGroup) : TelemedicinaItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.cita_item, parent, false) as FrameLayout
                return TelemedicinaItemViewHolder(view)
            }
        }
        fun bind(item: Cita, onAccederClick: (Cita) -> Unit, onCancelarClick: (Cita) -> Unit) {
            fechaCita.text = "${item.fecha} - ${item.hora}"
            tipoCita.text = item.tipo
            profesionalCita.text = item.profesional

            Log.i("TelemedicinaLogger", "init: $item")

            rootView.findViewById<LinearLayout>(R.id.modalidad)
                .visibility = View.GONE

            val accederBtn = rootView.findViewById<Button>(R.id.acceder_btn)
            val params = accederBtn.layoutParams as FrameLayout.LayoutParams
            val topMarginDp = 160
            val scale = accederBtn.context.resources.displayMetrics.density
            params.topMargin = (topMarginDp * scale + 0.5f).toInt()
            accederBtn.layoutParams = params
            if (item.hora == "10:00 AM") {
                accederBtn.visibility = View.VISIBLE
            } else {
                accederBtn.visibility = View.GONE
            }
            accederBtn.setOnClickListener{
                onAccederClick(item)
            }
            rootView.findViewById<Button>(R.id.cancelar_btn).setOnClickListener {
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