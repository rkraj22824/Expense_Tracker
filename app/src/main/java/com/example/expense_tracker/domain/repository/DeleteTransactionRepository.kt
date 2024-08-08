package com.example.expense_tracker.domain.repository


interface DeleteTransactionRepository {
    suspend fun deleteTransaction(id: String)
}