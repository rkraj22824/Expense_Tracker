package com.example.expense_tracker.data.repository


import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.repository.RegisterRepository
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegisterRepositroyImp @Inject constructor(
    private val fAuth:FirebaseAuth
): RegisterRepository {
    override fun registeruser(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Flow<Resource<AuthResult>> {
        return flow {

        }
        }

    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        TODO("Not yet implemented")
    }

    override fun logoutUser(): Flow<Resource<Boolean>> {
        TODO("Not yet implemented")
    }
}