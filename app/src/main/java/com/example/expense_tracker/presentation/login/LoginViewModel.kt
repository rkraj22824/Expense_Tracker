package com.example.expense_tracker.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
):ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    private val _loginResult = MutableStateFlow("")
    val loginResult: StateFlow<String> = _loginResult


    fun onEvent(event: LoginEvents){
        when(event){
            is LoginEvents.onEmailValueChange -> {
                viewModelScope.launch {
                    _loginState.value = loginState.value.copy(
                        email = event.email
                    )
                }
            }
            is LoginEvents.onPasswordValueChange -> {
                viewModelScope.launch {
                    _loginState.value = loginState.value.copy(
                        password = event.password
                    )
                }
            }
            is LoginEvents.onLoginClick -> {
                viewModelScope.launch {
                    authUseCase.loginUseCase(
                        email = event.email,
                        password = event.password
                    ).collect{
                        _loginResult.value = it.toString()
                    }
                }
            }
        }
    }
}
