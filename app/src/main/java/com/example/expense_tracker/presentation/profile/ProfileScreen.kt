package com.example.expense_tracker.presentation.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expense_tracker.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavController
) {
    var currentStatus = FirebaseAuth.getInstance().currentUser
    val viewModel: ProfileViewModel = hiltViewModel()
    val firstName = viewModel.firstName.collectAsState().value
    val lastName = viewModel.lastName.collectAsState().value
    val email = viewModel.email.collectAsState().value

    Scaffold(
        bottomBar = {
            BottomAppBar(

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(imageVector = Icons.Default.Home,
                        contentDescription = "Home Screen",
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.HomeScreen.route)
                        }
                    )
                    Icon(imageVector = Icons.Default.Dashboard,
                        contentDescription = "All transactions",
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.AllTransactionScreen.route)
                        }
                    )
                    Icon(imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.ProfileScreen.route)
                        })
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = firstName + " " + lastName)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = email)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                currentStatus = null
                FirebaseAuth.getInstance().signOut()
                navController.navigate(Screen.LoginScreen.route)
            }) {
                Text(text = "Sign Out")
            }
        }
    }
}