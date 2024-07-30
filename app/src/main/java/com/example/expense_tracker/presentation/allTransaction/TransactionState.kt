package com.example.expense_tracker.presentation.allTransaction

import com.example.expense_tracker.domain.model.Transaction

data class TransactionState(
    val Transactions : List<Transaction> = emptyList()
)
