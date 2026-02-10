package com.uv.apiintegration.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uv.apiintegration.RetrofitInstance
import com.uv.apiintegration.data.Post
import com.uv.apiintegration.data.UiState
import kotlinx.coroutines.launch


class PostViewModel : ViewModel() {

    var uiState by mutableStateOf<UiState<List<Post>>>(UiState.Loading)
        private set

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {

            uiState = UiState.Loading   // 👈 loading start

            try {
                val response = RetrofitInstance.api.getPosts()

                uiState = UiState.Success(response) // 👈 success

            } catch (e: Exception) {

                uiState = UiState.Error(
                    e.localizedMessage ?: "Something went wrong"
                )
            }
        }
    }
}
