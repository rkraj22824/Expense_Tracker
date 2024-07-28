package com.example.expense_tracker.navigation

sealed class Screen(val route: String) {
    object RegisterScreen : Screen("register_screen")
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")

}