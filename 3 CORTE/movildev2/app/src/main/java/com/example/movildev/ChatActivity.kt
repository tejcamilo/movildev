package com.example.movildev

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movildev.adapters.ChatAdapter
import com.example.movildev.databinding.ActivityChatBinding
import com.example.movildev.model.ChatMessage
import com.example.movildev.viewmodels.ChatViewModel

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private val viewModel by viewModels<ChatViewModel>()
    private lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* RecyclerView */
        adapter = ChatAdapter(mutableListOf())
        binding.recyclerChat.apply {
            layoutManager = LinearLayoutManager(this@ChatActivity)
            adapter = this@ChatActivity.adapter
        }

        /* OBSERVAR con tipo explícito */
        viewModel.messages.observe(this) { msgs: List<ChatMessage> ->
            adapter.updateData(msgs)                        // ← tu método
            binding.recyclerChat.scrollToPosition(msgs.lastIndex)
        }

        /* Botón enviar */
        binding.btnEnviar.setOnClickListener {
            val text = binding.etQuestion.text.toString().trim()
            if (text.isNotEmpty()) {
                binding.etQuestion.text?.clear()
                viewModel.send(text)
            }
        }
    }
}
