package com.kkeb.shoppinglist.ui.screens.eventdetails

import com.kkeb.shoppinglist.ui.screens.addevent.AddEventDetails

data class ItemDetails(
    val id: Long = 0,
    val eventId: Long = 0,
    val itemName: String = "",
    val price: String = "",
    val quantity: String = "",
)

data class ItemUIState(
    val isEdit: Boolean = false,
    val itemDetails: ItemDetails = ItemDetails(),
)

data class EventDetailsUIState(
    val eventDetails: AddEventDetails = AddEventDetails(),
    val itemList: List<ItemDetails> = emptyList(),
)