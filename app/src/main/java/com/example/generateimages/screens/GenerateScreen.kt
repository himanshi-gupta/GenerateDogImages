package com.example.generateimages.screens

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.generateimages.viewmodel.GenerateViewModel
import coil.compose.rememberImagePainter



@Composable
fun GenerateScreen(viewModel: GenerateViewModel = hiltViewModel()) {
    var imageUrl by remember { mutableStateOf<String?>(null) }

    imageUrl?.let {
        Image(painter = rememberImagePainter(it), contentDescription = "Dog Image")
    }

    Button(onClick = { viewModel.fetchRandomDog { imageUrl = it } }) {
        Text("Generate!")
    }


}
