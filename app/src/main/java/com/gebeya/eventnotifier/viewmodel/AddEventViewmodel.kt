package com.gebeya.eventnotifier.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.domain.repository.EventDBRepository
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.Result
import com.gebeya.eventnotifier.prettyPrint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class AddEventViewmodel @Inject constructor(
    val eventDBRepository: EventDBRepository,
    val eventRepository: EventRepository
): ViewModel() {

    val nameError = mutableStateOf("")
    val typeError = mutableStateOf("")

    fun insertEvent(event: Event){
        viewModelScope.launch {
            eventDBRepository.insertEvent(event)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun validateInput(
        name: String,
        type: String,
        eventDate: Instant
    ){
        if(name.isNullOrEmpty() || name.isNullOrBlank()){
            nameError.value = "Name is required"
        }else{
            nameError.value = ""
        }

        if(type.isNullOrEmpty() || type.isNullOrBlank()){
            typeError.value = "Type is required"
        }else{
            nameError.value = ""
        }

        val tomorrow = Calendar.getInstance()
        tomorrow.add(Calendar.DATE, 1)

        if(eventDate.isAfter(tomorrow.time.toInstant())){

        }
    }

    fun login(){
        viewModelScope.launch {
            val result = eventRepository.login()
            when(result){
                is Result.Fail -> println("login result: ${result.errorMessage}")
                is Result.Success -> println("login result: ${result.data}")
            }
        }
    }

    fun locations(){
        viewModelScope.launch {
            val result = eventRepository.getLocations()
            when(result){
                is Result.Fail -> println("get location: ${result.errorMessage}")
                is Result.Success -> println("get location: ${result.data?.filter { it.level == "region" }}")
            }
        }
    }

}