package com.example.expense_tracker.presentation.editTransaction

import com.example.expense_tracker.presentation.addTransaction.AddTransactionEvents

sealed class DetailsTransactionEvents {
     data class onDelete(val id: String) : DetailsTransactionEvents()
}