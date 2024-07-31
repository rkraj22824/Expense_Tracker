package com.example.expense_tracker.data.repository

import android.util.Log
import com.example.expense_tracker.domain.model.Transaction
import com.example.expense_tracker.domain.repository.AllTransactionRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AllTransactionRepositoryImp @Inject constructor(
    private val fStore: FirebaseFirestore
):AllTransactionRepository{
override suspend fun getAllTransaction(): Flow<List<Transaction>> = flow {
    try {
        val result = fStore.collection("Transactions").get().await()
        val transactions: MutableList<Transaction> = mutableListOf()
        result.forEach {
            transactions.add(it.toObject(Transaction::class.java))
        }
        emit(transactions)
    } catch (e: Exception) {
        Log.e("AllTransactionRepository", "Error in fetching transactions", e)
        emit(emptyList())
    }
}
}