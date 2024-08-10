package com.example.expense_tracker.domain.model


data class Transaction(
    val id: String= "",
    val title: String = "",
    val amount: Long = 0,
    val tag: String = "",
    val note: String = "",
    val type: String ="",
    val date: String=""

)
