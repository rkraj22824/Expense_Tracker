package com.example.expense_tracker.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker.domain.model.AllTransaction
import com.example.expense_tracker.domain.model.Transaction
import com.example.expense_tracker.domain.usecase.allTransactionUseCase.AllTransactionUseCase
import com.example.expense_tracker.presentation.AllTransactions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTransactionViewModel @Inject constructor(
    private val allTransactionUseCase: AllTransactionUseCase
) : ViewModel() {

    private val _transactions = MutableStateFlow(AllTransaction())
    val transactions: StateFlow<AllTransaction> = _transactions

    init {
        fetchTransactions()
    }

    private fun fetchTransactions() {
        viewModelScope.launch {
            allTransactionUseCase.getAllTransaction()
                .collect { allTransaction ->
                    _transactions.value = allTransaction
                }
        }
    }
}
