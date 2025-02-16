package com.example.generateimages.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.generateimages.viewmodel.GenerateViewModel
import coil.compose.rememberImagePainter



@Composable
fun GenerateScreen(viewModel: GenerateViewModel = hiltViewModel()) {
    var imageUrl by remember { mutableStateOf<String?>(null) }

    Column (modifier= Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        imageUrl?.let {
            Image(painter = rememberImagePainter(it), contentDescription = "Dog Image")
        }

        Button(onClick = { viewModel.fetchRandomDog { imageUrl = it } }) {
            Text("Generate!")
        }
    }

}
