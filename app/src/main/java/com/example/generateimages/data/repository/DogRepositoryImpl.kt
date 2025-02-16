package com.example.generateimages.data.repository

import com.example.generateimages.data.local.CacheManager
import com.example.generateimages.data.model.DogResponse
import com.example.generateimages.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val cacheManager: CacheManager
) : DogRepository {

    override suspend fun fetchRandomDog(): DogResponse {
        return withContext(Dispatchers.IO) {
            val response = apiService.getRandomDog()
            cacheManager.saveImage(response.message)
            response
        }
    }

    override fun getCachedDogs(): Flow<List<String>> = flow {
        emit(cacheManager.getImages())
    }

    override fun clearCache() {
        cacheManager.clearImages()
    }
}
