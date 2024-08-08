package com.example.expense_tracker.domain.repository


import com.example.expense_tracker.common.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AddTransactionRepository {
    suspend fun addTransaction(id:String,title: String, amount: Long, type: String, tag: String, note: String,date:String):Flow<Resource<AuthResult>>
}