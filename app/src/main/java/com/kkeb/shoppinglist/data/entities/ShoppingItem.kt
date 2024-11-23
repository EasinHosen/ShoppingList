package com.kkeb.shoppinglist.data.entities

data class ShoppingItem(
    val id: Long = 0,
    val eventId: Long,
    val itemName: String,
    val price: Double = 0.0,
    val quantity: Double = 1.0,
)