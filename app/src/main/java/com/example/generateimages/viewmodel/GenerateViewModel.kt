package com.example.generateimages.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.generateimages.data.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import retrofit2.HttpException
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class GenerateViewModel @Inject constructor(private val repository: DogRepository) : ViewModel() {
    lateinit var imageUrl: String

    fun fetchRandomDog(onSuccess: (String) -> Unit) {
        viewModelScope.launch (Dispatchers.IO){
            try {
                val response = repository.fetchRandomDog()
                imageUrl = response.message
                onSuccess(imageUrl)
            } catch (e: HttpException) {
                error("HTTP Error: ${e.code()}")
            } catch (e: JsonSyntaxException) {
                error("Invalid JSON Response")
            } catch (e: Exception) {
                error("Something went wrong: ${e.message}")
            }
        }
    }
}
