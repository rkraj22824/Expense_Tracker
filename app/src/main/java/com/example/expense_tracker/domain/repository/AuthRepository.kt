package com.example.expense_tracker.domain.repository

import com.example.expense_tracker.common.Resource
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow


interface AuthRepository{
     fun currentUser(): FirebaseUser?
    suspend fun register(firstName: String, lastName: String, email: String, password: String): Flow<Resource<AuthResult>>
    suspend fun login(email: String, password: String): Flow<Resource<AuthResult>>
    fun logout(): Flow<Resource<Unit>>
}