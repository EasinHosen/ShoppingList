package com.kkeb.shoppinglist.ui.screens.eventdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kkeb.shoppinglist.customui.ShoppingListAppBar

@Composable
fun EventDetailsScreen(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingListAppBar(
                title = "Event Details",
                hasBack = true,
                navigateUp = navigateUp
            )
        }
    ) { innerPadding ->
        Text(
            text = "Event Details Screen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}