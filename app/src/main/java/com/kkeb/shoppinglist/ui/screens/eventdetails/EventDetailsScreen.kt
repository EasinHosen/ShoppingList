package com.kkeb.shoppinglist.ui.screens.eventdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.kkeb.shoppinglist.customui.ShoppingListAppBar
import kotlinx.coroutines.launch

@Composable
fun EventDetailsScreen(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    viewModel: EventDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.eventDetailsUIState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            ShoppingListAppBar(
                title = "Event Details",
                hasBack = true,
                navigateUp = navigateUp
            )
        },
        floatingActionButton ={
            ExtendedFloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        viewModel.addItem()
                    }
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Item")
                Text("Add Item")
            }
        }
    ) { innerPadding ->
        Text(
            text = "Event Details Screen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}