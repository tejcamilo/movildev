package com.example.movildev.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movildev.data.remote.RetrofitProvider
import com.example.movildev.model.ChatMessage
import com.example.movildev.repository.ChatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val repo = ChatRepository(RetrofitProvider.create())

    // LiveData expone una lista inmutable
    private val _messages = MutableLiveData<List<ChatMessage>>(emptyList())
    val messages: LiveData<List<ChatMessage>> = _messages

    fun send(question: String) {
        // 1. Mensaje del usuario
        addMessage(ChatMessage(
            question, isUser = true,
            text = TODO()
        ))

        viewModelScope.launch(Dispatchers.IO) {
            val answerMsg = try {
                val answer = repo.ask(question)
                ChatMessage(
                    answer, isUser = false,
                    text = TODO()
                )
            } catch (e: Exception) {
                ChatMessage(
                    "Error al contactar con el servidor 🤖", isUser = false,
                    text = TODO()
                )
            }
            addMessage(answerMsg)
        }
    }

    /** Agrega un mensaje creando SIEMPRE una nueva lista */
    private fun addMessage(msg: ChatMessage) {
        val nueva = _messages.value.orEmpty().toMutableList().apply { add(msg) }
        _messages.postValue(nueva)          // referencia distinta → DiffUtil lo ve
    }
}
