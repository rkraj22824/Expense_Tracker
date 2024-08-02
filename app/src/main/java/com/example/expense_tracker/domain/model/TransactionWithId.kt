package com.example.expense_tracker.domain.model

data class TransactionWithId(
    val id: String,
    val transaction: Transaction
)
