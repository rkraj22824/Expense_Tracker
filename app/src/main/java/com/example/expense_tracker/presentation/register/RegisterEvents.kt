package com.example.expense_tracker.presentation.register

sealed class RegisterEvents {

    data class onFirstNameChange(val firstname: String) : RegisterEvents()
    data class onLastNameChange(val lastname: String) : RegisterEvents()
    data class onEmailChange(val email: String) : RegisterEvents()
    data class onPasswordChange(val password: String) : RegisterEvents()
    data class onRegisterClick(
        val firstname: String, val lastname: String, val email: String, val password: String
    ) : RegisterEvents()

}