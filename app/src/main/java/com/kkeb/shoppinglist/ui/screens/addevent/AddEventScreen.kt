package com.kkeb.shoppinglist.ui.screens.addevent

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kkeb.shoppinglist.customui.ShoppingListAppBar

@Composable
fun AddEventScreen(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            ShoppingListAppBar(
                title = "Add Event",
                hasBack = true,
                navigateUp = navigateUp
            )
        }
    ) { innerPadding ->
        Text(
            text = "Add Event Screen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}