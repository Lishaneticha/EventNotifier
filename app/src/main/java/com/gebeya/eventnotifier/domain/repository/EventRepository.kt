package com.gebeya.eventnotifier.domain.repository

import com.gebeya.eventnotifier.data.network.entity.Event

interface EventRepository {

    suspend fun getEvent(): List<Event>

    suspend fun createEVent(event: Event): Event

    suspend fun getEventById(id: Int): Event

    suspend fun updateEvent()

    suspend fun deleteEvent()

}