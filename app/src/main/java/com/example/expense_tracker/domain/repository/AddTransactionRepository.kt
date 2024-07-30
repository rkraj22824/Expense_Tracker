package com.example.expense_tracker.domain.repository


import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.model.Transaction
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AddTransactionRepository {
    suspend fun addTransaction(title: String, amount: String, type: String, tag: String, note: String):Flow<Resource<AuthResult>>
    suspend fun getProfile(): Flow<Transaction>
}