package com.example.expense_tracker.domain.model

data class Transaction(
    val title: String,
    val amount: Int,
    val tag: String,
    val note: String,
)
