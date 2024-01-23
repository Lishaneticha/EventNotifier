package com.gebeya.eventnotifier.domain.repository

import com.gebeya.eventnotifier.data.network.entity.AuthenticationToken
import com.gebeya.eventnotifier.data.network.entity.Event
import com.gebeya.eventnotifier.data.network.entity.Location
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface EventRepository {

    suspend fun getEvent(): Result<List<Event>>

    suspend fun createEVent(event: Event): Event

    suspend fun getEventById(id: Int): Result<Event>

    suspend fun updateEvent()

    suspend fun deleteEvent()

    fun timer(): Flow<Int>

    suspend fun login(): Result<AuthenticationToken>

    suspend fun getLocations(): Result<List<Location>>

}