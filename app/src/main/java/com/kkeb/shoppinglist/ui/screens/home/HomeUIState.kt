package com.kkeb.shoppinglist.ui.screens.home

import com.kkeb.shoppinglist.data.entities.ShoppingEvent

data class HomeUIState(
    val shoppingEventList: List<ShoppingEvent> = emptyList(),
)