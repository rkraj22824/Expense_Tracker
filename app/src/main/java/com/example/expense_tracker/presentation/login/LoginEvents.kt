package com.example.expense_tracker.presentation.login

sealed class LoginEvents {

    data class onEmailValueChange(val email: String) : LoginEvents()
    data class onPasswordValueChange(val password: String) : LoginEvents()
    data class onLoginClick(val email: String,val password: String) : LoginEvents()

}