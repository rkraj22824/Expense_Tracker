package com.example.expense_tracker.data.repository

import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.repository.AuthRepository
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImp @Inject constructor(
    private val fAuth: FirebaseAuth
) : AuthRepository {
    override fun currentUser(): FirebaseUser? {
        return fAuth.currentUser
    }

    override suspend fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Flow<Resource<AuthResult>> = flow {
        try {
            emit(Resource.Loading())
            val result= fAuth.createUserWithEmailAndPassword(email,password).await()
            emit(Resource.Success(result))
        }catch (e:Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }

    override suspend fun login(email: String, password: String): Flow<Resource<AuthResult>> = flow {
        try {
            emit(Resource.Loading())
            val result = fAuth.signInWithEmailAndPassword(email,password).await()
            emit(Resource.Success(result))
        }catch (e:Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }

    override fun logout(): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }

}