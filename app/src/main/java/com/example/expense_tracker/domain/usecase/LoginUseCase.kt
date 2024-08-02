package com.example.expense_tracker.domain.usecase

import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.repository.AuthRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email:String,password:String): Flow<Resource<AuthResult>> {
        return authRepository.login(email,password)
    }
}