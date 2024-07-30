package com.example.expense_tracker.presentation.state

data class RegisterState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = ""
)
