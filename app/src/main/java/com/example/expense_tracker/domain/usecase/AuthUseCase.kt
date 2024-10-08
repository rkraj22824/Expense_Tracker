package com.example.expense_tracker.domain.usecase

data class AuthUseCase(
    val registerUseCase: RegisterUseCase,
    val loginUseCase: LoginUseCase,
)