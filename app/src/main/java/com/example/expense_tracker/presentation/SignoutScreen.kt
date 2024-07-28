package com.example.expense_tracker.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SignOutScreen(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "SignOutScreen")
        Button(onClick = {

        }) {
            Text(modifier = Modifier.align(Alignment.CenterVertically),
                text = "Sign Out")
        }

    }
}
@Preview(showBackground = true)
@Composable
fun previesch(modifier: Modifier = Modifier) {
    SignOutScreen()
}