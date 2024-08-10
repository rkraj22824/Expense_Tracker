package com.example.expense_tracker.presentation.detailTransaction


import android.app.AlertDialog
import android.widget.Button
import android.widget.Toast
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expense_tracker.navigation.Screen
import com.example.expense_tracker.presentation.allTransaction.AllTransactionViewModel
//
//@Composable
//fun DetailsTransactionScreen(
//    navController: NavController,
//    id: String
//) {
//    val viewModel = hiltViewModel<AllTransactionViewModel>()
//    val state = viewModel.transactionById.collectAsState().value
//    val detailViewModel = hiltViewModel<DeleteTransactionViewModel>()
//    val context = LocalContext.current
//
//    LaunchedEffect(Unit) {
//        viewModel.fetchTransactionById(id)
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(35.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Text(
//            text = "Transaction",
//            color = Color.Black,
//            fontSize = 26.sp,
//            fontWeight = FontWeight.Bold,
//        )
//        Spacer(modifier = Modifier.height(32.dp))
//
//        Card(
//            shape = RoundedCornerShape(16.dp),
//            modifier = Modifier.heightIn(450.dp)
//        ) {
//
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(24.dp),
//
//                ) {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End
//                ) {
//                    IconButton(
//                        onClick = {
////                            detailViewModel.onEvent(DetailsTransactionEvent.onDelete(id))
////                            navController.navigate(Screen.HomeScreen.route)
////                            Toast.makeText(context, "Deleted Transaction", Toast.LENGTH_SHORT).show()
//                        }
//                    ) {
//                        Icon(
//                            imageVector = Icons.Outlined.Delete,
//                            contentDescription = "Delete",
//                            tint = Color.Black,
//                            modifier = Modifier.size(40.dp),
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.height(32.dp))
//                Text(
//                    text = "Title",
//                    color = Color.Black,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Text(
//                    text = state.title,
//                    modifier = Modifier.fillMaxWidth(),
//                    color = Color.Black.copy(alpha = 0.7f),
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Spacer(modifier = Modifier.height(32.dp))
//                Text(
//                    text = "Amount",
//                    color = Color.Black,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = state.amount.toString(),
//                    modifier = Modifier.fillMaxWidth(),
//                    color = Color.Black.copy(alpha = 0.7f),
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Spacer(modifier = Modifier.height(32.dp))
//                Text(
//                    text = "Type",
//                    color = Color.Black,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = state.type,
//                    modifier = Modifier.fillMaxWidth(),
//                    color = Color.Black.copy(alpha = 0.7f),
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Spacer(modifier = Modifier.height(32.dp))
//                Text(
//                    text = "Tag",
//                    color = Color.Black,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = state.tag,
//                    modifier = Modifier.fillMaxWidth(),
//                    color = Color.Black.copy(alpha = 0.7f),
//                    maxLines = 5,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Spacer(modifier = Modifier.height(32.dp))
//                Text(
//                    text = "When",
//                    color = Color.Black,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = state.date,
//                    modifier = Modifier.fillMaxWidth(),
//                    color = Color.Black.copy(alpha = 0.7f),
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//
//            }
//        }
//        Spacer(modifier = Modifier.height(4.dp))
//    }
//
//}


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf

@Composable
fun DetailsTransactionScreen(
    navController: NavController,
    id: String
) {
    val viewModel = hiltViewModel<AllTransactionViewModel>()
    val state = viewModel.transactionById.collectAsState().value
    val detailViewModel = hiltViewModel<DeleteTransactionViewModel>()
    val context = LocalContext.current

    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.fetchTransactionById(id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAD9E6))
            .padding(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Transaction",
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(32.dp))

        Card(
            colors = CardColors(
                containerColor = Color(0xFFD16C97),
                disabledContainerColor = Color.White,
                contentColor = Color.White,
                disabledContentColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.heightIn(450.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),

                ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = {
                            showDialog = true // Show the alert dialog
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Delete",
                            tint = Color.White.copy(0.7f),
                            modifier = Modifier.size(40.dp),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Title",
                    color = Color.White.copy(0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = state.title,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Amount",
                    color = Color.White.copy(0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = state.amount.toString(),
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Type",
                    color = Color.White.copy(0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = state.type,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Tag",
                    color = Color.White.copy(0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = state.tag,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "When",
                    color = Color.White.copy(0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = state.date,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }
        Spacer(modifier = Modifier.height(4.dp))

        // Alert Dialog for confirming deletion
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false // Dismiss the dialog when touched outside
                },
                title = {
                    Text(text = "Delete Transaction")
                },
                text = {
                    Text("Are you sure you want to delete this transaction?")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            detailViewModel.onEvent(DetailsTransactionEvent.onDelete(id))
                            showDialog = false
                            Toast.makeText(context, "Deleted Transaction", Toast.LENGTH_SHORT).show()
                            navController.navigate(Screen.HomeScreen.route)
                        }
                    ) {
                        Text("Delete")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog = false // Dismiss the dialog
                        },
                        colors = ButtonDefaults.buttonColors()
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}
