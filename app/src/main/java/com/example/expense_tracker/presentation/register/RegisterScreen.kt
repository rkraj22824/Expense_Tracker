package com.example.expense_tracker.presentation.register


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expense_tracker.navigation.Screen


@Composable
fun SignupScreen(
navController: NavController
) {
    val viewModel: RegisterViewModel = hiltViewModel()

    val firstName = viewModel.registerState.collectAsState().value.firstName
    val lastName = viewModel.registerState.collectAsState().value.lastName
    val email = viewModel.registerState.collectAsState().value.email
    val password = viewModel.registerState.collectAsState().value.password


    val toastMessage = viewModel.authResult.collectAsState().value

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hey there,",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp),
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = "Create an Account",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                value = firstName ,
                onValueChange = {
                    viewModel.onEvent(RegisterEvents.onFirstNameChange(it))
                },
                label = {
                    Text(text = "First Name")
                        },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Account"
                    )
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                value = lastName ,
                onValueChange = {
                    viewModel.onEvent(RegisterEvents.onLastNameChange(it))
                },
                label = {
                    Text(text = "Last Name")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Account"
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                value = email,
                onValueChange = {
                    viewModel.onEvent(RegisterEvents.onEmailChange(it))
                },
                label = { Text(text = "Email") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email"
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                value = password,
                onValueChange = {
                    viewModel.onEvent(RegisterEvents.onPasswordChange(it))
                },
                label = { Text(text = "Password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password"
                    )
                }
            )


            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    viewModel.onEvent(
                        RegisterEvents.onRegisterClick(
                        firstName,lastName,email,password
                    ))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(48.dp)
            ) {
                Text(
                    text = "Register",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {Text("Already have an account? ", modifier = Modifier)
                TextButton(onClick = {
                    navController.navigate(Screen.LoginScreen.route)
                                     },
                    modifier = Modifier
                ) {
                    Text("Login")
                }
            }

        }
    }
}

