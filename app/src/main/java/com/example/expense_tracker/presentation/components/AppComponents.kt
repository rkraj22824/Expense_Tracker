package com.example.expense_tracker.presentation.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expense_tracker.presentation.addTransaction.AddTransactionEvents
import com.example.expense_tracker.presentation.addTransaction.AddTransactionViewModel

@Composable
fun SignupFooter(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {Text("Don't have an account? ", modifier = Modifier.wrapContentSize(Alignment.Center))
        TextButton(onClick = { navController.navigate("login") },
            modifier = Modifier.wrapContentSize(Alignment.Center)
        ) {
            Text("Login")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenu(

) {
    val viewModel = hiltViewModel<AddTransactionViewModel>()
    val value:Array<String> = arrayOf("Expense","Income")
    val expanded = viewModel.addTransactionState.collectAsState().value.isExpanded
    val selectedText = viewModel.addTransactionState.collectAsState().value.selectedText

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                viewModel.onEvent(AddTransactionEvents.onExpanded(true))
            }
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = {
                },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
                shape = RoundedCornerShape(16.dp)
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { viewModel.onEvent(AddTransactionEvents.onExpanded(false)) }
            ) {
                value.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(
                            text = item
                        ) },
                        onClick = {
                            viewModel.onEvent(AddTransactionEvents.onSelected(item))
                            viewModel.onEvent(AddTransactionEvents.onExpanded(false))
                        }
                    )
                }
            }
        }
    }
}