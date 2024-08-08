package com.example.expense_tracker.data.repository

import com.example.expense_tracker.domain.repository.DeleteTransactionRepository
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteTransactionRepositoryImp @Inject constructor(
    private val fStore:FirebaseFirestore
): DeleteTransactionRepository {
    override suspend fun deleteTransaction(id: String) {
        fStore.document("Transactions").collection(id)
    }
}