package com.gebeya.eventnotifier.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.data.db.entity.Address
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.Ticket
import com.gebeya.eventnotifier.data.db.entity.User
import com.gebeya.eventnotifier.domain.repository.EventDBRepository
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.LocationServiceRepository
import com.gebeya.eventnotifier.domain.repository.Result
import com.gebeya.eventnotifier.prettyPrint
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    val eventRepository: EventRepository,
    val eventDBRepository: EventDBRepository,
    val locationServiceRepository: LocationServiceRepository
): ViewModel() {

    val second: MutableStateFlow<Int> = MutableStateFlow(0)
    val location: MutableStateFlow<LatLng?> = MutableStateFlow(null)
    init {
        getSecond()
        getLocation()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertAll(){
        viewModelScope.launch {

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

    fun getSecond(){
        viewModelScope.launch {
            eventRepository.timer().collect{
                second.value = it
            }
        }
    }

    fun getLocation(){
        viewModelScope.launch {
            locationServiceRepository.requestLocationUpdate().collect{
                location.value = it
            }
        }
    }
}