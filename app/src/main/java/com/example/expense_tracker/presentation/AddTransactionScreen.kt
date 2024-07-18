package com.example.expense_tracker.presentation

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddTransaction(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.heightIn(550.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Add transaction",
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(36.dp))
                OutlinedTextField(value = "Enter a Title", onValueChange = {},
                    shape = RoundedCornerShape(16.dp))
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(value = "Enter Amount", onValueChange = {},
                    shape = RoundedCornerShape(16.dp))
                Spacer(modifier = Modifier.height(20.dp))

                DropdownMenuItem(text = {"Transaction Type" }, onClick = {

                })
                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(value = "Tags", onValueChange = {},
                    shape = RoundedCornerShape(16.dp))
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(value = "Note if any", onValueChange = {},
                    shape = RoundedCornerShape(16.dp))

                Spacer(modifier = Modifier.height(36.dp))
                Button(
                    onClick = {

                    },
                    modifier=Modifier,
                    colors = ButtonDefaults.buttonColors(),
                ) {
                    Text(text = "Save")

                }

            }
        }
        Spacer(modifier = Modifier.height(4.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun LetsSytbee(modifier: Modifier = Modifier) {
    AddTransaction()
}