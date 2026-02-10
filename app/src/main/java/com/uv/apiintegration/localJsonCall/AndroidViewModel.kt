package com.uv.apiintegration.localJsonCall

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.uv.apiintegration.data.UiState
import kotlinx.coroutines.launch

class PostViewModel(application: Application) : AndroidViewModel(application) {

    var uiState by mutableStateOf<UiState<List<Post>>>(UiState.Loading)
        private set

    init {
        loadLocalPosts()
    }

    private fun loadLocalPosts() {
        viewModelScope.launch {
            try {
                uiState = UiState.Loading

                val json = readJsonFromAssets(
                    getApplication(),
                    "posts.json"
                )

                val posts = parsePosts(json)

                uiState = UiState.Success(posts)

            } catch (e: Exception) {
                uiState = UiState.Error("Failed to load local data")
            }
        }
    }
}
