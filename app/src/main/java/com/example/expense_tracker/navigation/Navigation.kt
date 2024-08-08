package com.example.expense_tracker.navigation


import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.expense_tracker.presentation.addTransaction.AddTransactionScreen
import com.example.expense_tracker.presentation.allTransaction.AllTransactionViewModel
import com.example.expense_tracker.presentation.allTransaction.AllTransactions
import com.example.expense_tracker.presentation.register.SignupScreen
import com.example.expense_tracker.presentation.homeScreen.HomeScreen
import com.example.expense_tracker.presentation.detailTransaction.DetailsTransactionScreen
import com.example.expense_tracker.presentation.login.LoginScreen
import com.example.expense_tracker.presentation.profile.ProfileScreen
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(

) {
    Scaffold {

        val navController = rememberNavController()
        val startDestination = if (FirebaseAuth.getInstance().currentUser != null) {
            Screen.HomeScreen.route
        } else {
            Screen.LoginScreen.route
        }
        NavHost(navController = navController, startDestination = startDestination) {
            composable(Screen.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(Screen.RegisterScreen.route) {
                SignupScreen(navController)
            }
            composable(Screen.HomeScreen.route) {
                HomeScreen(navController)
            }
            composable(Screen.ProfileScreen.route){
                ProfileScreen(navController)
            }
            composable(Screen.AddTransactionScreen.route) {
                AddTransactionScreen(navController)
            }
            composable(Screen.DetailsTransactionScreen.route){
                val id = it.arguments?.getString("id") ?: ""
                DetailsTransactionScreen(navController, id)
            }
            composable(Screen.AllTransactionScreen.route ){
                AllTransactions(
                    navController = navController
                )
            }
        }
    }
}
