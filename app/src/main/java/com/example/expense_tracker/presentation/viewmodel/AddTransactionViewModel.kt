package com.example.expense_tracker.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expense_tracker.domain.model.Transaction
import com.example.expense_tracker.domain.usecase.addTransaction.AddTransactionUseCase
import com.example.expense_tracker.presentation.events.AddTransactionEvents
import com.example.expense_tracker.presentation.state.AddTransactionState

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private  val addTransactionUseCase: AddTransactionUseCase
):ViewModel() {

    private val _addTransactionState = MutableStateFlow(AddTransactionState())
    val addTransactionState: StateFlow<AddTransactionState> = _addTransactionState

    private val _addResult = MutableStateFlow("")
    val addResult: StateFlow<String> = _addResult

    private val _selectedText = MutableStateFlow(AddTransactionState())
    val selectedText: StateFlow<AddTransactionState> = _selectedText

    fun onEvent(event:AddTransactionEvents){
        when(event){
            is AddTransactionEvents.onAmountChange -> {
                _addTransactionState.value = addTransactionState.value.copy(
                    amount = event.amount
                )
            }
            is AddTransactionEvents.onNoteChange -> {
                _addTransactionState.value = addTransactionState.value.copy(
                    note = event.note
                )
            }
            is AddTransactionEvents.onTagChange ->{
                _addTransactionState.value = addTransactionState.value.copy(
                    tag = event.tag
                )
            }
            is AddTransactionEvents.onTitleChange -> {
                _addTransactionState.value = addTransactionState.value.copy(
                    title = event.title
                )
            }
            is AddTransactionEvents.onSaveClick -> {
                viewModelScope.launch {
                    addTransactionUseCase(
                        title = event.title,
                        amount = event.amount,
                        tag = event.tag,
                        type = event.type,
                        note = event.note
                    ).collect{
                        _addResult.value=it.toString()
                    }
                }
            }

            is AddTransactionEvents.onTypeChange -> {
                _addTransactionState.value = addTransactionState.value.copy(
                    type = event.type
                )
            }
            is AddTransactionEvents.onExpanded -> {
                _addTransactionState.value = addTransactionState.value.copy(
                    isExpanded = event.expanded
                )
            }

            is AddTransactionEvents.onSelected -> {
                _addTransactionState.value = addTransactionState.value.copy(
                    selectedText = event.selectedValue
                )

            }
        }
    }

}