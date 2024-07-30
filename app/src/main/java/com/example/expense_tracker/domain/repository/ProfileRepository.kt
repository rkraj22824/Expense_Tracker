package com.example.expense_tracker.domain.repository

import com.example.expense_tracker.domain.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getProfile(): Flow<Profile>
}