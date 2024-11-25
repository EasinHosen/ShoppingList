package com.kkeb.shoppinglist.ui.screens.addevent

import com.kkeb.shoppinglist.data.entities.ShoppingEvent
import com.kkeb.shoppinglist.utils.stringToDate
import java.util.Date

data class AddEventDetails(
    val id: Long = 0,
    val name: String = "",
    val initialBudget: Double = 0.0,
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
    initialBudget = initialBudget,
    totalCost = totalCost,
    eventDate = stringToDate(eventDate) ?: Date(),
    completed = completed,
)

