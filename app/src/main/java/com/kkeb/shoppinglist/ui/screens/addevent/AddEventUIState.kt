package com.kkeb.shoppinglist.ui.screens.addevent

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

