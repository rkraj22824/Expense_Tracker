package com.example.expense_tracker.navigation


import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expense_tracker.presentation.SignupScreen
import com.example.expense_tracker_app.presentation.HomeScreen
import com.example.expense_tracker_app.presentation.LoginScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {
    Scaffold() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
            composable(Screen.LoginScreen.route){
                LoginScreen(navController = navController)
            }
            composable(Screen.SignupScreen.route){
                SignupScreen(navController)
            }
            composable(Screen.HomeScreen.route){
                HomeScreen()
            }
        }
    }

}