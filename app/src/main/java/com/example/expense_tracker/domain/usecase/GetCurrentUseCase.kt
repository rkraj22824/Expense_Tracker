package com.example.expense_tracker.domain.usecase

import com.example.expense_tracker.data.repository.AuthRepositoryImp
import com.example.expense_tracker.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject


class GetCurrentUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
     fun invoke(): FirebaseUser? {
         return authRepository.currentUser()
     }
}