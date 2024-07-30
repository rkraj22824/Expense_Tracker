package com.example.expense_tracker.domain.usecase.profile

import com.example.expense_tracker.domain.model.Profile
import com.example.expense_tracker.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend fun getProfile(): Flow<Profile> {
        return profileRepository.getProfile()
    }
}