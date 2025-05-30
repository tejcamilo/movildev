package com.example.movildev.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.databinding.ItemMessageUserBinding
import com.example.movildev.databinding.ItemMessageApiBinding   // ← nuevo
import com.example.movildev.model.ChatMessage

class ChatAdapter(mutableListOf: MutableList<Any>) :
    ListAdapter<ChatMessage, RecyclerView.ViewHolder>(Diff()) {

    companion object {
        private const val TYPE_USER = 0
        private const val TYPE_API  = 1
    }

    override fun getItemViewType(position: Int): Int =
        if (getItem(position).isUser) TYPE_USER else TYPE_API

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_USER) {
            val b = ItemMessageUserBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
            UserVH(b)
        } else {
            val b = ItemMessageApiBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
            ApiVH(b)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = getItem(position)
        when (holder) {
            is UserVH -> holder.binding.tvUserMessage.text = msg.text
            is ApiVH  -> holder.binding.tvApiMessage.text  = msg.text
        }
    }

    fun updateData(msgs: List<ChatMessage>) {

    }

    /* ---- DiffUtil ---- */
    private class Diff : DiffUtil.ItemCallback<ChatMessage>() {
        override fun areItemsTheSame(o: ChatMessage, n: ChatMessage) = o.id == n.id
        override fun areContentsTheSame(o: ChatMessage, n: ChatMessage) = o == n
    }

    /* ---- ViewHolders ---- */
    class UserVH(val binding: ItemMessageUserBinding) : RecyclerView.ViewHolder(binding.root)
    class ApiVH (val binding: ItemMessageApiBinding)  : RecyclerView.ViewHolder(binding.root)
}
