package com.gebeya.eventnotifier.domain.repository

import com.gebeya.eventnotifier.data.network.entity.Event

interface EventRepository {

    suspend fun getEvent(eventId: Int): Event

    suspend fun updateEvent()

    suspend fun deleteEvent()

}