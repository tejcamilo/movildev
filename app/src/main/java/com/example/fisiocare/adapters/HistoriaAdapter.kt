package com.example.fisiocare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fisiocare.Model.HistoriaClinica
import com.example.fisiocare.databinding.ItemHistoriaBinding

class HistoriaAdapter :
    ListAdapter<HistoriaClinica, HistoriaAdapter.HistoriaViewHolder>(HistoriaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoriaViewHolder {
        val binding = ItemHistoriaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HistoriaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoriaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HistoriaViewHolder(private val binding: ItemHistoriaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(historia: HistoriaClinica) {
            binding.tvNombre.text = historia.nombreCompleto
            binding.tvDocumento.text = historia.documento
        }
    }

    class HistoriaDiffCallback : DiffUtil.ItemCallback<HistoriaClinica>() {
        override fun areItemsTheSame(oldItem: HistoriaClinica, newItem: HistoriaClinica): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HistoriaClinica, newItem: HistoriaClinica): Boolean {
            return oldItem == newItem
        }
    }
}
