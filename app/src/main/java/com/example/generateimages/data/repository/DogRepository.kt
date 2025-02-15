package com.example.generateimages.data.repository

import com.example.generateimages.data.model.DogResponse
import kotlinx.coroutines.flow.Flow

interface DogRepository  {
    suspend fun fetchRandomDog(): DogResponse
    fun getCachedDogs(): Flow<List<String>>
    fun clearCache()
}
