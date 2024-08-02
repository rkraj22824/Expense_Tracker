package com.example.expense_tracker.domain.usecase

import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.repository.AddTransactionRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class AddTransactionUseCase @Inject constructor(
    private val addTransactionRepository: AddTransactionRepository
){
    suspend operator  fun invoke(id: String,title: String, amount: Long, type: String, tag: String, note: String,date:String): Flow<Resource<AuthResult>> {
        return addTransactionRepository.addTransaction(id,title, amount, type, tag, note,date)
    }
}