package com.gebeya.eventnotifier.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.data.network.entity.Event
import com.gebeya.eventnotifier.domain.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    val eventRepository: EventRepository
): ViewModel() {

    var eventList: List<Event> by mutableStateOf(listOf())
    var event: Event? by mutableStateOf(null)

    fun getEvent(){
        viewModelScope.launch { eventList = eventRepository.getEvent() }
    }

    fun createEvent(event: Event){
        viewModelScope.launch {
            val event = eventRepository.createEVent(event = event)
            println("network data created: $event")
        }
    }

    fun getEventById(id: Int){
        viewModelScope.launch {
            event = eventRepository.getEventById(id)
        }
    }

}