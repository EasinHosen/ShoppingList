package com.kkeb.shoppinglist.ui.screens.eventdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.kkeb.shoppinglist.data.entities.ShoppingItem
import com.kkeb.shoppinglist.data.repositories.ShoppingEventRepository
import com.kkeb.shoppinglist.data.repositories.ShoppingItemRepository
import com.kkeb.shoppinglist.routes.EventDetailRoute
import com.kkeb.shoppinglist.ui.screens.addevent.AddEventDetails
import com.kkeb.shoppinglist.ui.screens.addevent.toAddEventDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val shoppingEventRepository: ShoppingEventRepository,
    private val shoppingItemRepository: ShoppingItemRepository
) : ViewModel() {
    private val detailsRoute: EventDetailRoute = savedStateHandle.toRoute<EventDetailRoute>()

    private val _eventDetailsUIState = MutableStateFlow(EventDetailsUIState())
    val eventDetailsUIState = _eventDetailsUIState.asStateFlow()

    init {
        viewModelScope.launch {
            shoppingEventRepository.getShoppingEventWithItems(detailsRoute.id).collect { map ->
                Log.d("EventDetailsViewModel", ": $map")
                val entry = map.entries.firstOrNull()
                _eventDetailsUIState.update {
                    it.copy(
                        eventDetails = entry?.key?.toAddEventDetails()
                            ?: AddEventDetails(name = detailsRoute.name),
                        itemList = entry?.value?.map { item -> item.toItemDetails() } ?: emptyList()
                    )

                }

            }
        }
    }

    suspend fun addItem() {
        val item = ShoppingItem(eventId = detailsRoute.id, itemName = "New Item")
        shoppingItemRepository.insertShoppingItem(item)
    }
}