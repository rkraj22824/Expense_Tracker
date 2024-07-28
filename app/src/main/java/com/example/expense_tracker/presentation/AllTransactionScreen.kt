package com.example.expense_tracker.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AllTransactions(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier

            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Transactions", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))
//
//        if (transactionList.list.isEmpty()) {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "No recent transactions..",
//                    color = Color(0xFFD16C97),
//                )
//            }
//
//        } else {
//            LazyColumn(
//                contentPadding = PaddingValues(
//                    8.dp, 0.dp, 8.dp, 64.dp
//                ),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                items(transactionList.list) {
//                    TransactionCard(transaction = it) {
//                        navHostController.navigate(Screen.TransactionDetails.withArgs(it.id.toString()))
//
//                    }
//                }
//
//            }
//        }
    }
}