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
class DetailScreenViewModel @Inject constructor(
    val eventRepository: EventRepository
): ViewModel() {

    var event: Event? by mutableStateOf(null)
    var networkError: String? by mutableStateOf(null)

    fun getEventById(id: Int){
        viewModelScope.launch {
            val result = eventRepository.getEventById(id)
            when(result){
                is Result.Fail -> networkError = result.errorMessage
                is Result.Success -> {
                    networkError = null
                    event = result.data
                }
            }
        }
    }

}