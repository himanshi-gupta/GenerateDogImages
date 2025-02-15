package com.example.generateimages.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CacheManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("dog_cache", Context.MODE_PRIVATE)

    fun saveImage(url: String) {
        val images = getImages().toMutableList()
        if (images.size >= 20) images.removeAt(0) // Keep only 20 recent images
        images.add(url)
        prefs.edit().putString("dog_images", Gson().toJson(images)).apply()
    }

    fun getImages(): List<String> {
        val json = prefs.getString("dog_images", "[]")
        return Gson().fromJson(json, object : TypeToken<List<String>>() {}.type) ?: emptyList()
    }

    fun clearImages() {
        prefs.edit().remove("dog_images").apply()
    }
}
