package com.gebeya.eventnotifier.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.domain.repository.EventDBRepository
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.LocationServiceRepository
import com.gebeya.eventnotifier.domain.repository.Result
import com.gebeya.eventnotifier.prettyPrint
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
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
        getLocations()
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

    fun login(){
        viewModelScope.launch {
            val result = eventRepository.login()
            when(result){
                is Result.Fail -> println("Login result: ${result.errorMessage}")
                is Result.Success -> println("Login result: ${result.data}")
            }
        }
    }

    fun getLocations(){
        viewModelScope.launch {
            val result = eventRepository.getLocations()
            when(result){
                is Result.Fail -> println("Login result: ${result.errorMessage}")
                is Result.Success -> println("Login result: ${result.data?.filter { it.level == "region" }}")
            }
        }
    }
}