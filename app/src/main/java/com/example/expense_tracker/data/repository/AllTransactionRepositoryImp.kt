package com.example.expense_tracker.data.repository


import android.util.Log
import com.example.expense_tracker.domain.model.Transaction
import com.example.expense_tracker.domain.model.TransactionWithId
import com.example.expense_tracker.domain.repository.AllTransactionRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AllTransactionRepositoryImp @Inject constructor(
    private val fStore: FirebaseFirestore,
    private val fAuth: FirebaseAuth
) : AllTransactionRepository {
    override suspend fun getAllTransaction(): Flow<List<TransactionWithId>> = flow {
        try {
            val result = fStore.collection("users").document(fAuth.currentUser!!.uid).collection("Transactions").get().await()
            val transactions: MutableList<TransactionWithId> = mutableListOf()
            var id: String
            result.forEach {
                id = it.id
                transactions.add(TransactionWithId(id, it.toObject(Transaction::class.java)))
            }
            Log.d("letsSee", "Addbdhfdubf")


            emit(transactions)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}