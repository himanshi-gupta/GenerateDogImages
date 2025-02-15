package com.example.generateimages.screens

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
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    appName: String,
    navController: NavController){
    Column (modifier= Modifier
    .fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(appName)
        Button(
            onClick = { navController.navigate("generate") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(top = 20.dp)

        ) { Text("Generate Dogs!") }
        Button(
            onClick = { navController.navigate("gallery") },
            shape = RoundedCornerShape(20.dp),

            ) {
            Text("My Recently Generated Dogs!")
        }
    }
}
