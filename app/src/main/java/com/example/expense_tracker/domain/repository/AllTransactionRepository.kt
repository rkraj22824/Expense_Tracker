package com.example.expense_tracker.domain.repository

import com.example.expense_tracker.domain.model.Transaction
import kotlinx.coroutines.flow.Flow


interface AllTransactionRepository {
    suspend fun getAllTransaction(): Flow<List<Transaction>>
}