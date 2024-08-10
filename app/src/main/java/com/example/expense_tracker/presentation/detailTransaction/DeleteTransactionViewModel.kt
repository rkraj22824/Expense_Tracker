package com.example.expense_tracker.presentation.detailTransaction

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker.domain.usecase.DeleteTransactionUseCase
import com.example.expense_tracker.presentation.homeScreen.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteTransactionViewModel @Inject constructor(
    private val deleteTransactionUseCase: DeleteTransactionUseCase
):ViewModel() {

    fun onEvent(event: DetailsTransactionEvent) {
        when(event){
            is DetailsTransactionEvent.onDelete -> {
                viewModelScope.launch {
                    deleteTransactionUseCase.invoke(event.id)
                }
            }
        }
    }
}