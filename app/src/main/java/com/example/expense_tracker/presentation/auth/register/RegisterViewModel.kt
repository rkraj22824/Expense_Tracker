package com.example.expense_tracker.presentation.auth.register


import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.data.repository.AuthRepositoryImp
import com.example.expense_tracker.domain.usecase.AuthUseCase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.rpc.context.AttributeContext
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private  val authUseCase: AuthUseCase
) : ViewModel() {


    private val _registerState = MutableStateFlow(RegisterState())
    val registerState: StateFlow<RegisterState> = _registerState

    private val _authResult = MutableStateFlow("")
    val authResult: StateFlow<String> = _authResult

    fun onEvent(event: RegisterEvents) {
        when (event) {
            is RegisterEvents.onFirstNameChange -> {
                _registerState.value = registerState.value.copy(
                    firstName = event.firstname
                )
            }

            is RegisterEvents.onLastNameChange -> {
                _registerState.value = registerState.value.copy(
                    lastName = event.lastname
                )
            }

            is RegisterEvents.onEmailChange -> {
                _registerState.value = registerState.value.copy(
                    email = event.email
                )
            }

            is RegisterEvents.onPasswordChange -> {
                _registerState.value = registerState.value.copy(
                    password = event.password
                )
            }

            is RegisterEvents.onRegisterClick -> {
                viewModelScope.launch {
                    authUseCase.registerUseCase(
                        firstName = event.firstname,
                        lastName = event.lastname,
                        email = event.email,
                        password = event.password
                    ).collect{
                        _authResult.value = it.toString()
                    }
                }
            }
        }
    }
}

