package com.example.expense_tracker.presentation.allTransaction

 sealed class AllTransactionEvent {
     data class onTypeChange(val type: String) : AllTransactionEvent()
     data class onExpanded(val expanded: Boolean): AllTransactionEvent()
     data class onIdUpdate(val id: String): AllTransactionEvent()
 }