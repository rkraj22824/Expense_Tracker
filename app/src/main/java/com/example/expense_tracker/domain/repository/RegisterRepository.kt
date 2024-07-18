package com.example.expense_tracker.domain.repository

import com.example.expense_tracker.common.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow


interface RegisterRepository  {

    fun registeruser(firstName: String, lastName: String, email: String, password: String): Flow<Resource<AuthResult>>

    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>

    fun logoutUser(): Flow<Resource<Boolean>>

}