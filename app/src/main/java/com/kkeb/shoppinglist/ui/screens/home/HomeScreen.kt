package com.kkeb.shoppinglist.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kkeb.shoppinglist.customui.ShoppingListAppBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            ShoppingListAppBar(
                title = "Home",
            )
        }
    ) { innerPadding ->
        Text(
            text = "Home Screen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}