package com.uv.apiintegration.localJsonCall

import android.content.Context

fun readJsonFromAssets(context: Context, fileName: String): String {
    return context.assets.open(fileName)
        .bufferedReader()
        .use { it.readText() }
}
