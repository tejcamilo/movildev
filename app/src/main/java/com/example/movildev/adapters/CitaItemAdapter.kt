package com.example.movildev.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.model.Cita
import com.example.movildev.R

class CitaItemAdapter : RecyclerView.Adapter<CitaItemAdapter.CitaItemViewHolder>() {
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
        holder.bind(item)

    }

    class CitaItemViewHolder(val rootView : TextView) : RecyclerView.ViewHolder(rootView) {
        companion object {
            fun inflateFrom(parent: ViewGroup) : CitaItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.cita_item, parent, false) as TextView
                return CitaItemViewHolder(view)
            }
        }
        fun bind(item: Cita) {
            rootView.text = item.fecha
        }
    }
}