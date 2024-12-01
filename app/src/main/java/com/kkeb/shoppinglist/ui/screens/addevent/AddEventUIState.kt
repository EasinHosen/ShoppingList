package com.kkeb.shoppinglist.ui.screens.addevent

import com.kkeb.shoppinglist.data.entities.ShoppingEvent
data class AddEventDetails(
    val id: Long = 0,
    val name: String = "",
    val initialBudget: String = "0.0",
    val totalCost: Double = 0.0,
    val eventDate: String = "",
    val completed: Boolean = false,
)

data class AddEventUIState(
    val eventDetails: AddEventDetails = AddEventDetails(),
    val isEntryValid: Boolean = false,
)

fun AddEventDetails.toShoppingEvent() = ShoppingEvent(
    id = id,
    name = name,
    initialBudget = initialBudget.toDoubleOrNull() ?: 0.0,
    totalCost = totalCost,
    eventDate = eventDate,
    completed = completed,
)

fun ShoppingEvent.toAddEventDetails() = AddEventDetails(
    id = id,
    name = name,
    initialBudget = initialBudget.toString(),
    totalCost = totalCost,
    eventDate = eventDate,
    completed = completed,
)
