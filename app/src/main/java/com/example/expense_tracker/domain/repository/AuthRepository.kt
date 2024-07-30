package com.example.expense_tracker.domain.repository

import com.example.expense_tracker.common.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow


interface AuthRepository{
    suspend fun register(firstName: String, lastName: String, email: String, password: String): Flow<Resource<AuthResult>>
    suspend fun login(email: String, password: String): Flow<Resource<AuthResult>>
}