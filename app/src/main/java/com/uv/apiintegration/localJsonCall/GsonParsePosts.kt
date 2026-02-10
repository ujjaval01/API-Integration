package com.uv.apiintegration.localJsonCall

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.uv.apiintegration.localJsonCall.Post

fun parsePosts(json: String): List<Post> {
    val type = object : TypeToken<List<Post>>() {}.type
    return Gson().fromJson(json, type)
}
