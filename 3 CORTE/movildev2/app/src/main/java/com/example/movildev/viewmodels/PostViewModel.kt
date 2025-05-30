// com/example/movildev/viewmodels/PostViewModel.kt
package com.example.movildev.viewmodels

import androidx.lifecycle.*
import com.example.movildev.model.Post
import com.example.movildev.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    fun fetchPosts() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val result = RetrofitClient.api.getPosts()
            withContext(Dispatchers.Main) { _posts.value = result }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) { _posts.value = emptyList() }
        }
    }
}
