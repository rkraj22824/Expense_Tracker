package com.example.expense_tracker.presentation.addTransaction

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expense_tracker.navigation.Screen
import com.example.expense_tracker.presentation.components.ExposedDropdownMenu


@Composable
fun AddTransactionScreen(
    navController: NavController,
) {

    val viewModel: AddTransactionViewModel = hiltViewModel()
    val state = viewModel.addTransactionState.collectAsState().value
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAD9E6))
            .padding(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Card(
            colors = CardColors(
                containerColor = Color(0xFFD16C97),
                disabledContainerColor = Color.White,
                contentColor = Color.White,
                disabledContentColor = Color.White
            ),
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
                TextField(
                    value = state.title, onValueChange = {
                    viewModel.onEvent(AddTransactionEvents.onTitleChange(it))
                },label = {
                        Text(text = "Title")
                    },

                    colors = TextFieldDefaults.colors()
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(value = state.amount, onValueChange = {
                    viewModel.onEvent(AddTransactionEvents.onAmountChange(it))
                },label = {
                    Text(text = "Amount")
                },

                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Decimal
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))

                ExposedDropdownMenu()

                Spacer(modifier = Modifier.height(20.dp))

                TextField(value = state.tag, onValueChange = {
                    viewModel.onEvent(AddTransactionEvents.onTagChange(it))
                },label = {
                    Text(text = "Tag")
                },
                    )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(value = state.note, onValueChange = {
                    viewModel.onEvent(AddTransactionEvents.onNoteChange(it))
                },
                    label = {
                        Text(text = "Note...")
                    },
                    )

                Spacer(modifier = Modifier.height(36.dp))
                Button(
                    onClick = {
                        if(state.title.isNotEmpty() && state.amount!=null && state.tag.isNotEmpty() && state.note.isNotEmpty()){
                            Toast.makeText(context,"Transaction Added ",Toast.LENGTH_SHORT).show()
                            navController.navigate(Screen.HomeScreen.route)
                            viewModel.onEvent(AddTransactionEvents.onSaveClick(state.title,state.amount.toLong(),state.tag,state.note,state.selectedText))
                        }else{
                            Toast.makeText(context,"Please fill all the fields",Toast.LENGTH_SHORT).show()
                        }
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
