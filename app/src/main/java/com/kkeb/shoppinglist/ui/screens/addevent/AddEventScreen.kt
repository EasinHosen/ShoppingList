package com.kkeb.shoppinglist.ui.screens.addevent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kkeb.shoppinglist.customui.ShoppingListAppBar
import com.kkeb.shoppinglist.utils.getFormattedDateTime
import kotlinx.coroutines.launch

@Composable
fun AddEventScreen(
    navigateBack: () -> Unit,
    navigateUp: () -> Unit,
    viewModel: AddEventViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
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
            onSave = {
                coroutineScope.launch {
                    viewModel.saveEvent()
                    navigateBack()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventForm(
    uiState: AddEventUIState,
    onEventValueChange: (AddEventDetails) -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    var openDatePickerDialog by remember {
        mutableStateOf(false)
    }
    val datePickerState = rememberDatePickerState()

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
        DatePickerRow(
            openDatePicker = { openDatePickerDialog = true },
            state = datePickerState,
            modifier = modifier
        )
        DatePickerUI(
            shouldOpenDialog = openDatePickerDialog,
            state = datePickerState,
            onCancel = { openDatePickerDialog = false },
            onConfirm = {
                datePickerState.selectedDateMillis?.let {
                    onEventValueChange(uiState.eventDetails.copy(eventDate = getFormattedDateTime(it)))
                }
                openDatePickerDialog = false
            },
            onDismiss = { openDatePickerDialog = false }
        )
        Button(
            onClick = onSave,
            enabled = uiState.isEntryValid,
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerRow(
    openDatePicker: () -> Unit,
    state: DatePickerState,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {
        ElevatedButton(
            onClick = openDatePicker,
        ) {
            Text("Select Date")
        }
        Text(if (state.selectedDateMillis != null) getFormattedDateTime(state.selectedDateMillis!!) else "No Date selected")
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
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            value = addEventDetails.initialBudget.toString(),
            onValueChange = {
                onEventValueChange(addEventDetails.copy(initialBudget = it))
            },
            label = { Text("Initial Budget(Optional)") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerUI(
    shouldOpenDialog: Boolean,
    state: DatePickerState,
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {

    if (shouldOpenDialog) {
        val confirmEnable by remember {
            derivedStateOf { state.selectedDateMillis != null }
        }

        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(
                    enabled = confirmEnable,
                    onClick = onConfirm,
                    modifier = modifier,
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onCancel,
                    modifier = modifier
                ) {
                    Text("Cancel")
                }
            },
        ) {
            DatePicker(
                state = state,
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InputFieldPrev() {
    AddEventScreen(
        navigateBack = {},
        navigateUp = {}
    )
}