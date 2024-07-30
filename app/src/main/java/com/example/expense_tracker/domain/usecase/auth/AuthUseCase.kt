package com.example.expense_tracker.domain.usecase.auth

data class AuthUseCase(
    val registerUseCase: RegisterUseCase,
    val loginUseCase: LoginUseCase,
)