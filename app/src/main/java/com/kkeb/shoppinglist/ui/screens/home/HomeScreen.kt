package com.kkeb.shoppinglist.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kkeb.shoppinglist.customui.ShoppingListAppBar

@Composable
fun HomeScreen(
    navigateToAddEvent: () -> Unit,
    modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            ShoppingListAppBar(
                title = "Home",
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToAddEvent
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Event"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(16.dp)
        ) {
            Text(
                text = "Home Screen",
            )
        }
    }
}