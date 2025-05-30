package com.example.movildev.repository        // nueva carpeta ‘repository’



import com.example.movildev.network.OpenAiService
import com.example.movildev.network.dto.*

class ChatRepository(private val api: OpenAiService) {

    suspend fun ask(question: String): String {
        val body = ChatRequest(
            messages = listOf(Message("user", question))
        )
        val response = api.chatCompletions(body)
        return response.choices.first().message.content.trim()
    }
}
