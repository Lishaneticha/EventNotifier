package com.gebeya.eventnotifier.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.User
import com.gebeya.eventnotifier.domain.repository.EventDBRepository
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    val eventRepository: EventRepository,
    val eventDBRepository: EventDBRepository
): ViewModel() {

    fun insertAll(){
        viewModelScope.launch {
            eventDBRepository.insertAll(
                listOf(
                    Event(
                        date = "1/1/2024",
                        name = "Music concert",
                        type = "Concert",
                        location = "Gondar",
                        tags = listOf("Tag A", "Tag B")
                    ),
                    Event(
                        date = "2/2/2024",
                        name = "Art Gallery",
                        type = "Gallery",
                        location = "Hawassa",
                        tags = listOf("Tag C", "Tag D")
                    )
                ),
                User(
                    first_name = "John",
                    last_name = "Colun",
                    event_id = 1
                )
            )
        }
    }

    fun getAll(){
        viewModelScope.launch {
            println("DB data"+ eventDBRepository.getAll())
        }
    }

    fun getEventByID(id: Int){
        viewModelScope.launch {
            println("DB data"+ eventDBRepository.getEventByID(id))
        }
    }
}