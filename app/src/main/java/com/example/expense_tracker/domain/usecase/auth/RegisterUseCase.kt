package com.example.expense_tracker.domain.usecase.auth

import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.repository.AuthRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(firstName: String, lastName: String, email: String, password: String): Flow<Resource<AuthResult>> {
         return authRepository.register(firstName,lastName,email,password)
    }
}