package com.kkeb.shoppinglist.ui.screens.eventdetails

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kkeb.shoppinglist.customui.NoDataFound
import com.kkeb.shoppinglist.customui.ShoppingListAppBar
import com.kkeb.shoppinglist.ui.screens.addevent.AddEventDetails
import kotlinx.coroutines.launch

@Composable
fun EventDetailsScreen(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    viewModel: EventDetailsViewModel = hiltViewModel(),
) {
    val uiState by viewModel.eventDetailsUIState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    Scaffold(
        topBar = {
            ShoppingListAppBar(
                title = uiState.eventDetails!!.name,
                hasBack = true,
                navigateUp = navigateUp
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        viewModel.addItem()
                        if(uiState.itemList.isNotEmpty()){
                            listState.animateScrollToItem(uiState.itemList.size - 1)
                        }
                    }
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Item")
                Text("Add Item")
            }
        }
    ) { innerPadding ->
        if (uiState.itemList.isEmpty()) {
            NoDataFound(modifier = Modifier.padding(innerPadding))
            return@Scaffold
        }
        ItemListBuilder(
            eventDetails = uiState.eventDetails!!,
            itemList = uiState.itemList,
            lazyListState = listState,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ItemListBuilder(
    eventDetails: AddEventDetails,
    itemList: List<ItemDetails>,
    lazyListState: LazyListState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        state = lazyListState,
        modifier = modifier.fillMaxSize()
    ) {
        item {
            ListItem(
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                headlineContent = {
                    Text("Budget: ${eventDetails.initialBudget}")
                },
                trailingContent = {
                    Text("\$${eventDetails.totalCost}")
                }
            )
        }
        items(itemList, key = { it.id }) {
            ItemCard(itemDetails = it)
        }
        item {
            Spacer(modifier = modifier.size(70.dp))
        }
    }
}

@Composable
fun ItemCard(
    itemDetails: ItemDetails,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = {
            Text(itemDetails.itemName)
        },
        trailingContent = {
            Text("\$${itemDetails.price}", style = MaterialTheme.typography.bodyLarge)
        },
        supportingContent = {
            Text("Quantity: ${itemDetails.quantity}")
        },
        leadingContent = {
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Default.Edit, contentDescription = "Edit")
            }
        }
    )
}

@Preview(showSystemUi = false)
@Composable
private fun EventDetailsScreenPreview() {
    ItemCard(
        itemDetails = ItemDetails(
            id = 1,
            eventId = 1,
            itemName = "Item 1",
            price = "10.00",
            quantity = "1"
        )
    )
}