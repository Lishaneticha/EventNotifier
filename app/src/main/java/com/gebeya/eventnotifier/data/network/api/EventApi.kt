package com.gebeya.eventnotifier.data.network.api

import com.gebeya.eventnotifier.data.network.entity.Event
import retrofit2.http.GET
import retrofit2.http.POST

interface EventApi {

    @GET("entries")
    suspend fun getEvent(): Event

}