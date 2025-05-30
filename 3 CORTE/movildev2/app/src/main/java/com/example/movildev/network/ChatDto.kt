package com.example.movildev.network.dto

/* ---------- Petición ---------- */
data class Message(
    val role: String,          // "user", "assistant", "system"
    val content: String
)

data class ChatRequest(
    val model: String            = "gpt-3.5-turbo",
    val messages: List<Message>,
    val temperature: Double      = 0.7
)

/* ---------- Respuesta ---------- */
data class ChatCompletionResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)
