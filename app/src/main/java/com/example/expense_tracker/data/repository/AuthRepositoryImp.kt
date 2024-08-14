package com.example.expense_tracker.data.repository

import android.util.Log
import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.repository.AuthRepository
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImp @Inject constructor(
    private val fAuth: FirebaseAuth,
    private val fStore: FirebaseFirestore
) : AuthRepository {

    private val firestore = FirebaseFirestore.getInstance()
    override suspend fun register(
        firstName: String,
        lastName: String,
        email: String
        ,
        password: String
    ): Flow<Resource<AuthResult>> = flow {
        try {
            emit(Resource.Loading())
            val result = fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val users = hashMapOf(
                            "firstName" to firstName,
                            "lastName" to lastName,
                            "email" to email,
//                            "password" to password
                        )
                        fStore.collection("users").document(fAuth.currentUser!!.uid).set(users)
                    }
                }
            emit(Resource.Success(result.result))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }

    }

    override suspend fun login(email: String, password: String): Flow<Resource<AuthResult>> = flow {
        try {
            emit(Resource.Loading())
            val result = fAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}
