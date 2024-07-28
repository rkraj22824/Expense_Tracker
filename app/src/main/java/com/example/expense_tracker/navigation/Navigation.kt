package com.example.expense_tracker.navigation


import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expense_tracker.presentation.auth.register.RegisterViewModel
import com.example.expense_tracker.presentation.SignupScreen
import com.example.expense_tracker.presentation.HomeScreen
import com.example.expense_tracker.presentation.LoginScreen
import com.example.expense_tracker.presentation.auth.login.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(

) {
    Scaffold {

        val navController = rememberNavController()



        if(FirebaseAuth.getInstance().currentUser!=null){
            navController.navigate(Screen.HomeScreen.route)
        }else{
            navController.navigate(Screen.LoginScreen.route)
        }

        NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
            composable(Screen.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(Screen.RegisterScreen.route) {
                SignupScreen(navController)
            }
            composable(Screen.HomeScreen.route) {
                HomeScreen()
            }
        }

    }
}
