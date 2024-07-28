package com.example.expense_tracker.domain.usecase

data class AuthUseCase(
    val getCurrentUseCase: GetCurrentUseCase,
    val registerUseCase: RegisterUseCase,
    val loginUseCase: LoginUseCase,
    val logoutUseCase: LogoutUseCase

)