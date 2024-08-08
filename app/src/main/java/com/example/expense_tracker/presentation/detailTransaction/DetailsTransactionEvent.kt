package com.example.expense_tracker.presentation.detailTransaction

sealed class DetailsTransactionEvent {
     data class onDelete(val id: String) : DetailsTransactionEvent()
}