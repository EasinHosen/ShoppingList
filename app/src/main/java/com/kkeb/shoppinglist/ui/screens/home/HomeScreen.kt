package com.kkeb.shoppinglist.ui.screens.home

import android.view.RoundedCorner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.hilt.navigation.compose.hiltViewModel
import com.kkeb.shoppinglist.customui.ShoppingListAppBar
import com.kkeb.shoppinglist.data.entities.ShoppingEvent

@Composable
fun HomeScreen(
    navigateToAddEvent: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.homeUIState.collectAsState()
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
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (uiState.shoppingEventList.isEmpty()) {
                NoDataFound()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.shoppingEventList.size) { index ->
                        val event = uiState.shoppingEventList[index]
                        EventCard(
                            event = event,
                            onItemClick = {},
                            modifier = modifier
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NoDataFound(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        Text("No data available", textAlign = TextAlign.Center)
    }
}

@Composable
fun EventCard(
    event: ShoppingEvent,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    /*Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp)),
        onClick = onItemClick,
        shape = RectangleShape,
//        shadowElevation = 0.5.dp,
        color = Color.White,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 4.dp)
        ){
            Column(
                modifier = Modifier*//*.background(color = Color.Red)*//*.weight(1f)
            ) {
                Text(text = event.name,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                    )
                Text(text = event.eventDate)
            }
            Text(text = event.initialBudget.toString(), textAlign = TextAlign.Center, modifier = modifier.weight(0.2f))
        }
    }*/
    ListItem(
        leadingContent = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        },
        headlineContent = {
            Text(
                text = event.name,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        supportingContent = {
            Text(
                text = event.eventDate,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        trailingContent = {
            Text(
                text = event.totalCost.toString(),
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
    )

}

@Preview(showBackground = true)
@Composable
private fun EventCardPrev() {
    EventCard(
        event = ShoppingEvent(
            id = 1,
            name = "Event 1",
            initialBudget = 100.0,
            totalCost = 50.0,
            eventDate = "Fri, 10 Dec 2021",
            completed = false
        ),
        onItemClick = {}

        )
}


