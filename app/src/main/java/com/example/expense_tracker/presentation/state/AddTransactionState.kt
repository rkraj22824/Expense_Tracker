package com.example.expense_tracker.presentation.state

 data class AddTransactionState (
     val title: String = "",
     val amount: String = "",
     val tag: String = "",
     val note: String = "",
     val type: String = "",
     val isExpanded :Boolean =false,
     val selectedText: String ="Select Category"
 )