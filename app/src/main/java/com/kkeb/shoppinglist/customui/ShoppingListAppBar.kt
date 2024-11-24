package com.kkeb.shoppinglist.customui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListAppBar(
    title: String,
    hasBack: Boolean? = false,
    navigateUp: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            if (hasBack == true) {
                IconButton(
                    onClick = navigateUp
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")

                }
            } else null
        },
    )
}