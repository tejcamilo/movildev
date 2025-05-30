package com.example.movildev.network

import com.example.movildev.network.dto.ChatCompletionResponse
import com.example.movildev.network.dto.ChatRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAiService {

    @POST("chat/completions")
    suspend fun chatCompletions(
        @Body request: ChatRequest            // tu DTO del cuerpo
    ): ChatCompletionResponse                 // tu DTO de respuesta
}
