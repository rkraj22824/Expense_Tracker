package com.example.expense_tracker.presentation.allTransaction

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expense_tracker.navigation.Screen
import com.google.android.material.bottomnavigation.BottomNavigationItemView


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllTransactions(
    navController: NavController,
) {
    val viewModel = hiltViewModel<AllTransactionViewModel>()
    val transactionState = viewModel.transactions.collectAsState().value
    val typeState = viewModel.typeSelected.collectAsState().value

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .background(Color(0xFFE4AEC5))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home Screen",
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.HomeScreen.route)
                        },
                        )
                    Icon(imageVector = Icons.AutoMirrored.Filled.Assignment,
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
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFFAD9E6)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = " All Transactions",
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                modifier=Modifier.padding(20.dp),
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(22.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {


                val value: Array<String> = arrayOf("All","Expense", "Income")
                val expanded = viewModel.allTransactionState.collectAsState().value.isExpanded


                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            viewModel.onEvent(AllTransactionEvent.onExpanded(true)
                            )
                        }
                    ) {
                        OutlinedTextField(
                            value = typeState.selectedText,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier.menuAnchor()
                                .background(color = Color(0xFFD16C97)),
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = {
                                viewModel.onEvent(
                                    AllTransactionEvent.onExpanded(
                                        false
                                    )
                                )
                            }
                        ) {
                            value.forEach { item ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = item,
                                        )
                                    },
                                    onClick = {
                                        viewModel.onEvent(AllTransactionEvent.onTypeChange(item))
                                        viewModel.onEvent(AllTransactionEvent.onExpanded(false))
                                    }
                                )
                            }
                        }
                    }
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            if (transactionState.allTransaction.isEmpty()) {
                Text(text = "No transactions available")
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    if (typeState.selectedText == "All") {
                        items(transactionState.allTransaction) { transaction ->
                            TransactionItem(transaction = transaction){
                                Log.d("idcheck", it)
//                                viewModel.onEvent(AllTransactionEvent.onIdUpdate(it))
                                navController.navigate(Screen.DetailsTransactionScreen.sendId(it) )
                            }
                        }
                    } else {
                        items(transactionState.allTransaction.filter{
                            it.transaction.type == typeState.selectedText
                        }
                        ) { transaction ->
                            TransactionItem(transaction = transaction){
                                Log.d("idcheck", it)
                                //viewModel.onEvent(AllTransactionEvent.onIdUpdate(it))
                                navController.navigate(Screen.DetailsTransactionScreen.sendId(it))
                            }
                        }
                    }
                }
            }
        }
    }
}
