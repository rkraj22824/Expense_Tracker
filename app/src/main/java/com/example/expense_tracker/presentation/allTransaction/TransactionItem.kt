package com.example.expense_tracker.presentation.allTransaction

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.outlined.NorthEast
import androidx.compose.material.icons.outlined.SouthWest
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.expense_tracker.domain.model.TransactionWithId

@Composable
fun TransactionItem(
    transaction: TransactionWithId,
 //   modifier: Modifier = Modifier,
    onClick: (id: String) -> Unit
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .clickable(
                onClick = {
                    onClick(transaction.id)
                }
            )
            .background(Color(0xFFD16C97))
            .padding(19.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        if (transaction.transaction.type == "Income") {
            Icon(
                imageVector = Icons.Outlined.NorthEast,
                contentDescription = "Income Icon",
                tint = Color.Green,
                modifier = Modifier.size(40.dp)
            )
        } else {
            Icon(
                imageVector = Icons.Outlined.SouthWest,
                contentDescription = "Expense Icon",
                tint = Color.Red,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = transaction.transaction.title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.width(64.dp),
                    text = transaction.transaction.tag,
                    color = Color.White.copy(0.7f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {

                Text(
                    text = if (transaction.transaction.type == "Expense") {
                        "-${transaction.transaction.amount}"
                    } else {
                        "+${transaction.transaction.amount}"
                    },
                    color = Color.White,
                    fontSize = 18.sp,
                )
                Text(
                    text = transaction.transaction.date,
                    color = Color.White.copy(0.7f),
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}