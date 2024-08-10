package com.example.expense_tracker.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.expense_tracker.common.Resource
import com.example.expense_tracker.domain.usecase.AuthUseCase
import com.example.expense_tracker.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState


    private val _loginResult = MutableStateFlow(OnClickState())
    val loginResult: StateFlow<OnClickState> = _loginResult

//
//    fun onLoginCLick(){
//        viewModelScope.launch {
//
//        }
//    }

    fun onEvent(event: LoginEvents, navController: NavController) {
        when (event) {
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
                    ).collect {
                        when(it){
                            is Resource.Error -> {
                                _loginResult.value.copy(
                                    error = it.message.toString()
                                )
                            }
                            is Resource.Loading -> {
                                _loginResult.value.copy(
                                    loading = it.message.toString()
                                )
                            }
                            is Resource.Success -> {
                                navController.navigate(Screen.HomeScreen.route)
                            }
                        }
                    }
                }
            }
        }
    }
}