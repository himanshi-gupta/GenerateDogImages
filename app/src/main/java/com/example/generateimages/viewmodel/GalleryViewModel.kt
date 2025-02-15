package com.example.generateimages.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.generateimages.data.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: DogRepository) : ViewModel() {

    private val _dogImages = MutableStateFlow<List<String>>(emptyList())
    val dogImages = _dogImages.asStateFlow()

    init {
        fetchCachedDogs()
    }

    private fun fetchCachedDogs() {
        viewModelScope.launch {
            repository.getCachedDogs().collect { images ->
                _dogImages.value = images.reversed() // Reverse to show newest first
            }
        }
    }

    fun clearCache() {
        repository.clearCache()
        _dogImages.value = emptyList()
    }
}
