package com.example.generateimages.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.generateimages.screens.GalleryScreen
import com.example.generateimages.screens.GenerateScreen
import com.example.generateimages.screens.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Generate : Screen("generate")
    object Gallery : Screen("gallery")
}

@Composable
fun AppNavigation(appName: String, navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(appName, navController)
        }
        composable(Screen.Generate.route) {
            GenerateScreen()
        }
        composable(Screen.Gallery.route) {
            GalleryScreen()
        }
    }
}
