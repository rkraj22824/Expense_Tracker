package com.example.expense_tracker.presentation.addTransaction

 data class AddTransactionState (
     val id:String="",
     val title: String = "",
     val amount: String = "",
     val tag: String = "",
     val note: String = "",
     val type: String = "",
     val dateTime: String = "",
     val isExpanded :Boolean =false,
     val selectedText: String ="Select Category"
 )