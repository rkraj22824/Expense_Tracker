package com.example.expense_tracker.presentation.homeScreen

import android.util.Log
import androidx.lifecycle.SAVED_STATE_REGISTRY_OWNER_KEY
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker.domain.model.AllTransaction
import com.example.expense_tracker.domain.model.Transaction
import com.example.expense_tracker.domain.usecase.AllTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val allTransactionUseCase: AllTransactionUseCase
) : ViewModel() {

    private val _homeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState: StateFlow<HomeScreenState> = _homeScreenState.asStateFlow()

    private val _recentTransactionState = MutableStateFlow(RecentTransactionState())
    val recentTransactionState: StateFlow<RecentTransactionState> = _recentTransactionState

 init {
     fetchHomeScreenData()
 }

    fun fetchHomeScreenData() {
        viewModelScope.launch {
            allTransactionUseCase.getAllTransaction().collect{
                _homeScreenState.value = homeScreenState.value.copy(
                    totalBalance = it.allTransaction.filter {
                        it.transaction.type == "Expense"
                    }
                        .sumOf { it.transaction.amount } - it.allTransaction.filter { it.transaction.type == "Income" }
                        .sumOf { it.transaction.amount },
                    income = it.allTransaction.filter {
                        it.transaction.type == "Income"
                    }.sumOf { it.transaction.amount },
                    expense = it.allTransaction.filter {
                        it.transaction.type == "Expense"
                    }.sumOf { it.transaction.amount }
                )
//                _recentTransactionState.value = recentTransactionState.value.copy(
//                    list = it.allTransaction.takeLast(4).reversed()
//                )

            }

        }

    }

}