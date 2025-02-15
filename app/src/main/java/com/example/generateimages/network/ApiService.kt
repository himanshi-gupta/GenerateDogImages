package com.example.generateimages.network

import com.example.generateimages.data.model.DogResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/breeds/image/random/")
    suspend fun getRandomDog(): DogResponse
}
