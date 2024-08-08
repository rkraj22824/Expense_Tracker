package com.example.expense_tracker.domain.usecase

import com.example.expense_tracker.domain.repository.DeleteTransactionRepository
import javax.inject.Inject
import javax.inject.Singleton


//@Singleton
//class DeleteTransactionUseCase @Inject constructor(
//    private val deleteTransactionRepository: DeleteTransactionRepository
//) {
//    suspend operator fun invoke(id: String) {
//        return deleteTransactionRepository.deleteTransaction(id)
//    }
//}