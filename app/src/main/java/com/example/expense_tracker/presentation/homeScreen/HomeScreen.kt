package com.example.expense_tracker.presentation.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expense_tracker.navigation.Screen
import com.example.expense_tracker.presentation.allTransaction.TransactionItem
import com.example.expense_tracker.presentation.allTransaction.AllTransactionViewModel
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddTransactionScreen.route)
                },

            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "To Add Note",
                )
            }
        },
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
    ) {
        val viewModel = hiltViewModel<AllTransactionViewModel>()
        val transactionState = viewModel.transactions.collectAsState().value
        val typeState = viewModel.typeSelected.collectAsState().value
        val value: Array<String> = arrayOf("All", "Expense", "Income")
        val expanded = viewModel.allTransactionState.collectAsState().value.isExpanded


        val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
        val homeScreenState = homeScreenViewModel.homeScreenState.collectAsState().value

        val recentransactionState = homeScreenViewModel.recentTransactionState.collectAsState().value


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAD9E6))
                .padding(bottom = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier.padding(16.dp, 0.dp)
            ) {
                Card(
                    modifier = Modifier
                        .background(Color(0xFFD16C97)),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFD16C97)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Total Balance",
                                color = Color.White.copy(0.7f),
                                fontSize = 16.sp,

                                )

                            Text(
                                text = if (homeScreenState.totalBalance!! >= 0) {
                                    "-Rs${homeScreenState.totalBalance}"
                                } else {
                                    "+Rs${-homeScreenState.totalBalance!!}"
                                },
                                color = Color.White

                            )

                            Spacer(modifier = Modifier.height(24.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .background(Color(0xFFFAD9E6))
                                    ) {
                                        Icon(
                                            imageVector = Icons.Outlined.ArrowUpward,
                                            contentDescription = "Income",
                                            modifier = Modifier.size(40.dp),
                                            tint = Color.Green,
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))

                                    Column() {
                                        Text(
                                            text = "Income",
                                            color = Color.White.copy(0.7f),
                                            fontSize = 16.sp,
                                        )
                                        Text(
                                            text = "+Rs${homeScreenState.income}",
                                            color = Color.White

                                        )

                                    }
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .background(Color(0xFFFAD9E6))
                                    ) {
                                        Icon(
                                            imageVector = Icons.Outlined.ArrowDownward,
                                            contentDescription = "Expense",
                                            modifier = Modifier.size(40.dp),
                                            tint = Color.Red
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))

                                    Column() {
                                        Text(
                                            text = "Expense",
                                            color = Color.White.copy(0.7f),
                                            fontSize = 16.sp,
                                        )
                                        Text(
                                            text = "-Rs${homeScreenState.expense}",
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp, 16.dp),
                ) {
                    Text(text = "Recent Transactions...",
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                        )
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    if (typeState.selectedText == "All") {
                        items(transactionState.allTransaction) { transaction ->
    //                        recentransactionState.list.takeLast(5).reversed()
                            TransactionItem(transaction = transaction) {
                                navController.navigate(Screen.DetailsTransactionScreen.sendId(it))
                            }
                        }
                    }
                }
            }
        }
}