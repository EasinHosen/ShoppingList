package com.kkeb.shoppinglist.ui.screens.eventdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.kkeb.shoppinglist.data.repositories.ShoppingEventRepository
import com.kkeb.shoppinglist.routes.EventDetailRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EventDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val shoppingEventRepository: ShoppingEventRepository,
    private val shoppingItemRepository: ShoppingEventRepository
) : ViewModel(){
    private val detailsRoute: EventDetailRoute = savedStateHandle.toRoute<EventDetailRoute>()

    private val _eventDetailsUIState = MutableStateFlow(EventDetailsUIState())
    val eventDetailsUIState = _eventDetailsUIState.asStateFlow()
}