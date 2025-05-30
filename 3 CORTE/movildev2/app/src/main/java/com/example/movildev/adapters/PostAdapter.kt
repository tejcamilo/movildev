// com/example/movildev/adapters/PostAdapter.kt
package com.example.movildev.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.databinding.ItemPostBinding
import com.example.movildev.model.Post

class PostAdapter :
    ListAdapter<Post, PostAdapter.VH>(Diff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(getItem(position))

    class VH(private val b: ItemPostBinding) :
        RecyclerView.ViewHolder(b.root) {
        fun bind(post: Post) {
            b.tvTitle.text = post.title
            b.tvBody.text  = post.body
        }
    }

    private class Diff : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(o: Post, n: Post) = o.id == n.id
        override fun areContentsTheSame(o: Post, n: Post) = o == n
    }
}
