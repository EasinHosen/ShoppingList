package com.kkeb.shoppinglist.ui.screens.addevent

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AddEventViewModel : ViewModel() {
    var addEventUIState by mutableStateOf(AddEventUIState())

    fun updateUIState(addEventDetails: AddEventDetails) {
        addEventUIState = AddEventUIState(
            eventDetails = addEventDetails,
            isEntryValid = validateEntry(addEventDetails) 
        )
    }

    private fun validateEntry(eventDetails: AddEventDetails = addEventUIState.eventDetails): Boolean {
        return with(eventDetails) {
            name.isNotBlank() && eventDate.isNotBlank()
        }
    }
}