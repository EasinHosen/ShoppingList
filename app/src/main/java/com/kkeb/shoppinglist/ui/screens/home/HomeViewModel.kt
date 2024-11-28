package com.kkeb.shoppinglist.ui.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkeb.shoppinglist.data.entities.ShoppingEvent
import com.kkeb.shoppinglist.data.entities.ShoppingItem
import com.kkeb.shoppinglist.data.repositories.ShoppingEventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val shoppingEventRepository: ShoppingEventRepository
) : ViewModel() {
    private val _homeUIState = MutableStateFlow(HomeUIState())
    val homeUIState = _homeUIState.asStateFlow()

    init {
        viewModelScope.launch {
            shoppingEventRepository.getAllShoppingEvents()
                .collect { events ->
                    _homeUIState.update { it.copy(shoppingEventList = events) }
                }
        }
    }
}