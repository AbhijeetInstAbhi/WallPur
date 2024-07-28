package com.example.roadtosuccess.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
    object ProfileScreen : Screen("profile_screen")
    object DetailsScreen : Screen("details_screen")
    object AddToCartScreen : Screen("add_to_cart_screen")

}
