package com.example.expense_tracker.presentation.login

import com.example.expense_tracker.common.Resource
import java.lang.Error

data class LoginClickState (
    val success: Resource<String>,
    val error: Resource<String>,
    val loading:  Resource<String>,
    val nothing: Nothing
)