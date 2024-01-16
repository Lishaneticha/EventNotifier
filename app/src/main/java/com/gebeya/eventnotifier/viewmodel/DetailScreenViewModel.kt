package com.gebeya.eventnotifier.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.data.network.entity.Event
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    val eventRepository: EventRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var event: Event? by mutableStateOf(null)
    var networkError: String? by mutableStateOf(null)
    val eventId = savedStateHandle.get<Int>("id")
    val eventDetail = savedStateHandle.getStateFlow("id", 0).mapLatest {
        eventRepository.getEventById(it)
    }


}