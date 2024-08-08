package com.example.expense_tracker.presentation.homeScreen

import com.example.expense_tracker.domain.model.Transaction

class RecentTransactionState {
    val list: List<Transaction> = mutableListOf()
}