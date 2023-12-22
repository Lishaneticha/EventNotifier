package com.gebeya.eventnotifier.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gebeya.eventnotifier.domain.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    val eventRepository: EventRepository
): ViewModel() {

    fun getEvent(){
        viewModelScope.launch { eventRepository.getEvent(12) }
    }

}