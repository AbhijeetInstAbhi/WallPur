package com.example.roadtosuccess.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roadtosuccess.view.screens.HomeDesign
import com.example.roadtosuccess.view.screens.LoginScreen
import com.example.roadtosuccess.view.screens.ProfileScreen
import com.example.roadtosuccess.view.screens.SplashScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }


        composable(Screen.HomeScreen.route) {
            HomeDesign(navController = navController)
        }

        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }


    }
}