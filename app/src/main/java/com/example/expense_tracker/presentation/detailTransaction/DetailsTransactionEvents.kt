package com.example.expense_tracker.presentation.detailTransaction

sealed class DetailsTransactionEvents {
     data class onDelete(val id: String) : DetailsTransactionEvents()
}