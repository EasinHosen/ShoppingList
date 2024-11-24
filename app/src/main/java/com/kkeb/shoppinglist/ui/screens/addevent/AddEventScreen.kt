package com.kkeb.shoppinglist.ui.screens.addevent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kkeb.shoppinglist.customui.ShoppingListAppBar

@Composable
fun AddEventScreen(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    viewModel: AddEventViewModel = /*hiltViewModel()*/viewModel(),
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingListAppBar(
                title = "Add Event",
                hasBack = true,
                navigateUp = navigateUp
            )
        }
    ) { innerPadding ->
        AddEventForm(
            uiState = viewModel.addEventUIState,
            onEventValueChange = { viewModel.updateUIState(it) },
            onSave = { /*TODO*/ },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun AddEventForm(
    uiState: AddEventUIState,
    onEventValueChange: (AddEventDetails) -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TextInputFields(
            addEventDetails = uiState.eventDetails,
            onEventValueChange = onEventValueChange
        )
    }
}

@Composable
fun TextInputFields(
    addEventDetails: AddEventDetails,
    onEventValueChange: (AddEventDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            value = addEventDetails.name,
            onValueChange = { onEventValueChange(addEventDetails.copy(name = it)) },
            label = { Text("Event Name") },
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            value = addEventDetails.initialBudget.toString(),
            onValueChange = {},
            label = { Text("Initial Budget(Optional)") },
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InputFieldPrev() {
    AddEventForm(
        uiState = AddEventUIState(),
        onEventValueChange = {},
        onSave = {}
    )
}