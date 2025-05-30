package com.example.movildev.network

import com.example.movildev.model.Post
import retrofit2.http.GET          // ←  IMPORT NECESARIO

interface ApiService {
    @GET("posts")                 // ←  usa @GET
    suspend fun getPosts(): List<Post>
}
