package com.uv.apiintegration.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uv.apiintegration.RetrofitInstance
import com.uv.apiintegration.data.Post
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class PostViewModel : ViewModel() {

    var posts by mutableStateOf<List<Post>>(emptyList())
        private set

    var isRefreshing by mutableStateOf(false)
        private set

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                isRefreshing = true
                posts = RetrofitInstance.api.getPosts()
            } catch (e: Exception) {
                // error handle
            } finally {
                isRefreshing = false
            }
        }
    }
}

