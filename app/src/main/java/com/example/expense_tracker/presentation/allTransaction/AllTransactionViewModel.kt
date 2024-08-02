package com.example.expense_tracker.presentation.allTransaction

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker.domain.model.AllTransaction
import com.example.expense_tracker.domain.model.Transaction
import com.example.expense_tracker.domain.usecase.AllTransactionUseCase
import com.example.expense_tracker.presentation.addTransaction.AddTransactionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTransactionViewModel @Inject constructor(
    private val allTransactionUseCase: AllTransactionUseCase
) : ViewModel() {

    private val _transactions = MutableStateFlow(AllTransaction())
    val transactions: StateFlow<AllTransaction> = _transactions.asStateFlow()

    private val _id = MutableStateFlow("")
    val id: StateFlow<String> = _id.asStateFlow()

    private val _transactionById = MutableStateFlow(Transaction())
    val transactionById: StateFlow<Transaction> = _transactionById.asStateFlow()

    private val _typeSelected = MutableStateFlow(AllTransactionState())
    val typeSelected: StateFlow<AllTransactionState> = _typeSelected

    private val _allAllTransactionState = MutableStateFlow(AllTransactionState())
    val allTransactionState: StateFlow<AllTransactionState> = _allAllTransactionState


    fun fetchTransactionById() =
        viewModelScope.launch {
            _transactions.collect {
                it.allTransaction.filter { t ->
                    t.id == _id.value
                }.apply {
                    if (it.allTransaction.size != 0) {
                        _transactionById.value = it.allTransaction[0].transaction
                    }
                }
            }

        }


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

    fun onEvent(event: AllTransactionEvent) = viewModelScope.launch {
        when (event) {
            is AllTransactionEvent.onTypeChange -> {
                _typeSelected.value = typeSelected.value.copy(
                    selectedText = event.type
                )
            }

            is AllTransactionEvent.onExpanded -> {
                _allAllTransactionState.value = allTransactionState.value.copy(
                    isExpanded = event.expanded
                )

            }

            is AllTransactionEvent.onIdUpdate -> {
                _id.value = event.id
            }
        }
    }
}
