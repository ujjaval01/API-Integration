package com.uv.apiintegration

import com.uv.apiintegration.data.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

}