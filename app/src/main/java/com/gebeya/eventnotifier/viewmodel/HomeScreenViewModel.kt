package com.gebeya.eventnotifier.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.data.network.entity.Event
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    val eventRepository: EventRepository
): ViewModel() {

    var eventList: List<Event> by mutableStateOf(listOf())

    fun getEvents(){
        viewModelScope.launch {
            val result = eventRepository.getEvent()
            when(result){
                is Result.Fail -> TODO()
                is Result.Success -> eventList = result.data ?: listOf()
            }
        }
    }

}