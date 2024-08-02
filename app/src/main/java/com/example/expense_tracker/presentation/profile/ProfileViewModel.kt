package com.example.expense_tracker.presentation.profile


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker.domain.usecase.ProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase
) : ViewModel() {
    private val _firstName = MutableStateFlow("")
    val firstName = _firstName.asStateFlow()

    private val _lastName = MutableStateFlow("")
    val lastName = _lastName.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    init {
        getProfile()
    }

    private fun getProfile() = viewModelScope.launch {
        profileUseCase.getProfile().collect {
            _firstName.value = it.firstName
            _lastName.value = it.lastName
            _email.value = it.email
        }
    }
}