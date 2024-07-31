package com.example.expense_tracker.presentation

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DensitySmall
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.expense_tracker.domain.model.Transaction
import com.example.expense_tracker.navigation.Screen
import com.example.expense_tracker.presentation.viewmodel.AddTransactionViewModel
import com.example.expense_tracker.presentation.viewmodel.AllTransactionViewModel
import com.example.expense_tracker.presentation.viewmodel.TransactionItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllTransactions(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val viewModel = hiltViewModel<AllTransactionViewModel>()
    val transactionState = viewModel.transactions.collectAsState().value
    val transactions = transactionState.allTransaction

    Scaffold(
        bottomBar = {
            BottomAppBar {
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
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Transactions", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (transactions.isEmpty()){
                Text(text = "No transactions available")
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(transactions) { transaction ->
                        TransactionItem(transaction = transaction)
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Title: ${transaction.title}")
            Text(text = "Amount: ${transaction.amount}")
            Text(text = "Type: ${transaction.type}")
            Text(text = "Tag: ${transaction.tag}")
            Text(text = "Note: ${transaction.note}")
        }
    }
}
