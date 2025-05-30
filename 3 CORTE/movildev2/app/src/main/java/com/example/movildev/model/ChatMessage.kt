package com.example.movildev.model

data class ChatMessage(
    val id: String = System.currentTimeMillis().toString(),   // Long → String
    val text: String,
    val isUser: Boolean
)