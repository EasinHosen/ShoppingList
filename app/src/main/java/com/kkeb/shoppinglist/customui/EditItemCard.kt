package com.kkeb.shoppinglist.customui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkeb.shoppinglist.ui.screens.eventdetails.ItemDetails

@Composable
fun EditItemCard(
    itemDetails: ItemDetails,
    onValueChange: (ItemDetails) -> Unit,
    onItemUpdate: (ItemDetails) -> Unit,
    modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = {
            OutlinedTextField(
                value = itemDetails.itemName,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next,
                ),
                onValueChange = {
                    onValueChange(itemDetails.copy(itemName = it ))
                },
                label = { "Item Name" },
                modifier = modifier.fillMaxWidth()
            )
        },
        trailingContent = {
            IconButton(
                onClick = {
                    onItemUpdate(itemDetails)
                }
            ) {
                Icon(Icons.Default.Done, contentDescription = "Update Item")
            }
        },
        supportingContent = {
            Row{
                OutlinedTextField(
                    value = itemDetails.quantity,
                    onValueChange = {
                        onValueChange(itemDetails.copy(quantity = it))
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    label = { "Quantity" },
                    modifier = modifier.weight(1f)
                )
                Spacer(modifier= modifier.size(8.dp))
                OutlinedTextField(
                    value = itemDetails.price,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done ,
                    ),
                    onValueChange = {
                        onValueChange(itemDetails.copy(price = it))
                    },
                    label = { "Price" },
                    modifier = modifier.weight(1f)
                )
            }
        }
    )
}

@Preview
@Composable
private fun EditPreview() {
    EditItemCard(
        itemDetails = ItemDetails(
            id = 1,
            itemName = "Item 1",
            quantity = "1",
            price = "1.0",
            eventId = 1,
        ),
        onValueChange = {},
        onItemUpdate = {}
    )
}