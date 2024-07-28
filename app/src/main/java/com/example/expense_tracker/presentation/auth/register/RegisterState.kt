package com.example.expense_tracker.presentation.auth.register

import com.example.expense_tracker.common.Resource

data class RegisterState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = ""
)
