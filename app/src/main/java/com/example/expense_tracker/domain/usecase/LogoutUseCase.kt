package com.example.expense_tracker.domain.usecase

import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.data.repository.AuthRepositoryImp
import com.example.expense_tracker.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() : Flow<Resource<Unit>> {
        return authRepository.logout()
    }
}