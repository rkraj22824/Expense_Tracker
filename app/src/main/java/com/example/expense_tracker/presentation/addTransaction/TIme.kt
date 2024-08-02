package com.example.expense_tracker.presentation.addTransaction

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getFormattedTime(): String {
    val currentDateTime = Calendar.getInstance().time
    val formatter = SimpleDateFormat("MMM d, yyyy, hh:mm a", Locale.getDefault())
    return formatter.format(currentDateTime)
}