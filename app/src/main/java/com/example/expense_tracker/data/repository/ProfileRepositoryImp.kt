package com.example.expense_tracker.data.repository

import android.util.Log
import com.example.expense_tracker.domain.model.Profile
import com.example.expense_tracker.domain.repository.ProfileRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepositoryImp @Inject constructor(
    private val fAuth: FirebaseAuth,
    private val fStore: FirebaseFirestore
):ProfileRepository {
    var firstName = ""
    var lastName = ""
    var email = ""

    override suspend fun getProfile(): Flow<Profile> = flow {
        try{
            val task = fStore.collection("users").document(fAuth.currentUser!!.uid).get()
                .await()
            firstName = task.get("firstName") as String
            lastName = task.get("lastName") as String
            email = task.get("email") as String

            emit(Profile(firstName, lastName, email))
        }catch (e:Exception){
            Log.d("Error in getProfile", e.message.toString())
        }
    }
}