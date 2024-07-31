package com.example.expense_tracker.domain.usecase.allTransactionUseCase

import android.util.Log
import com.example.expense_tracker.domain.model.AllTransaction
import com.example.expense_tracker.domain.model.Transaction
import com.example.expense_tracker.domain.repository.AllTransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AllTransactionUseCase @Inject constructor(
    private val allTransactionRepository: AllTransactionRepository
) {
    suspend fun getAllTransaction(): Flow<AllTransaction> {
        return allTransactionRepository.getAllTransaction()
            .map { transactions ->
                Log.d("AllTransactionUseCase", "Mapping transactions")
                AllTransaction(transactions)
            }
    }
}