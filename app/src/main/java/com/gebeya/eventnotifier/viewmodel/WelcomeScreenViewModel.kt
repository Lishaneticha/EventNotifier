package com.gebeya.eventnotifier.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.data.db.entity.Address
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.Ticket
import com.gebeya.eventnotifier.data.db.entity.User
import com.gebeya.eventnotifier.domain.repository.EventDBRepository
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.Result
import com.gebeya.eventnotifier.prettyPrint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    val eventRepository: EventRepository,
    val eventDBRepository: EventDBRepository
): ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertAll(){
        viewModelScope.launch {
            eventDBRepository.insertAll(
                events = listOf(
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
                users = listOf(
                    User(
                        first_name = "John",
                        last_name = "Colun",
                        event_id = 1,
                        phone = "0923232323",
                        address = Address(null,null,null,null)
                    ),
                    User(
                        first_name = "Mike",
                        last_name = "Miller",
                        event_id = 1,
                        phone = "0911235689",
                        address = Address(null,null,null,null)
                    )
                ),
                tickets = listOf(
                    Ticket(
                        startDate = Instant.now(),
                        endDate = Instant.now(),
                        sold = true,
                        userId = 1,
                        eventId = 1
                    ),
                    Ticket(
                        startDate = Instant.now(),
                        endDate = Instant.now(),
                        sold = true,
                        userId = 2,
                        eventId = 1
                    )
                )
            )
        }
    }

    fun getAll(){
        viewModelScope.launch {
            println("DB data"+ eventDBRepository.getAll())
        }
    }

    fun getUserAndTicket(){
        viewModelScope.launch {
            println("User with Ticket "+ eventDBRepository.getUserAndTicket().prettyPrint())
        }
    }


}