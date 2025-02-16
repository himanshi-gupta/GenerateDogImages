package com.example.generateimages.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.generateimages.viewmodel.GalleryViewModel

@Composable
fun GalleryScreen(viewModel: GalleryViewModel = hiltViewModel()) {
    val dogImages by viewModel.dogImages.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "My Recently Generated Dogs", modifier = Modifier.padding(bottom = 8.dp))

        if (dogImages.isNotEmpty()) {
            LazyRow {
                items(dogImages) { imageUrl ->
                    Image(
                        painter = rememberImagePainter(imageUrl),
                        contentDescription = "Dog Image",
                        modifier = Modifier
                            .size(150.dp)
                            .padding(end = 8.dp)
                    )
                }
            }
        } else {
            Text(text = "No images found.")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.clearCache() }) {
            Text("Clear Dogs")
        }
    }
}
