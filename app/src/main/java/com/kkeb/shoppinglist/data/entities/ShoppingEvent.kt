package com.kkeb.shoppinglist.data.entities

import java.util.Date

data class ShoppingEvent(
    val id: Long = 0,
    val name: String,
    val initialBudget: Double = 0.0,
    val totalCost: Double = 0.0,
    val eventDate: Date,
    val completed: Boolean = false,
)