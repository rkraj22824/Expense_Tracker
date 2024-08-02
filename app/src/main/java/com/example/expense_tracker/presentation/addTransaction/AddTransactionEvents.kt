package com.example.expense_tracker.presentation.addTransaction

 sealed class AddTransactionEvents {
     data class onTitleChange(val title: String) : AddTransactionEvents()
     data class onAmountChange(val amount: String) : AddTransactionEvents()
     data class onTypeChange(val type: String) : AddTransactionEvents()
     data class onTagChange(val tag: String) : AddTransactionEvents()
     data class onNoteChange(val note: String) : AddTransactionEvents()
     data class onSaveClick(val title: String, val amount: Long, val tag: String, val note: String, val type: String) : AddTransactionEvents()
     data class onExpanded(val expanded: Boolean): AddTransactionEvents()
     data class onSelected(val selectedValue: String): AddTransactionEvents()

 }