package com.gebeya.eventnotifier.data.network.repository

import androidx.core.graphics.createBitmap
import com.gebeya.eventnotifier.data.network.api.EventApi
import com.gebeya.eventnotifier.data.network.entity.Event
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventRepositoryImpl(
    var eventApi: EventApi
): EventRepository {

    override suspend fun getEvent(eventId: Int): Event {
        val result = eventApi.getEvent()
        println("network data: $result")
        return result
    }

    override suspend fun updateEvent() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteEvent() {
        TODO("Not yet implemented")
    }
}