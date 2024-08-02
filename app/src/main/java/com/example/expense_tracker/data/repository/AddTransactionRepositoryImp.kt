package com.example.expense_tracker.data.repository


import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.repository.AddTransactionRepository
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddTransactionRepositoryImp @Inject constructor(
    private val fAuth: FirebaseAuth,
    private val fStore: FirebaseFirestore
) : AddTransactionRepository {
    override suspend fun addTransaction(
        id: String,
        title: String,
        amount: Long,
        type: String,
        tag: String,
        note: String,
        date: String
    ): Flow<Resource<AuthResult>> = flow {
        try {
            val result = fStore.collection("Transactions").add(
                hashMapOf(
                    "id"  to id,
                    "title" to title,
                    "amount" to amount,
                    "tag" to tag,
                    "note" to note,
                    "type" to type,
                    "date" to date
                )
            )
        } catch (e: Exception) {

        }
    }

}