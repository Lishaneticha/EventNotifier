package com.gebeya.eventnotifier.data.network.api

import com.gebeya.eventnotifier.data.network.entity.Event
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface EventApi {

    @GET("IRz9Lw/data")
    suspend fun getEvent(): List<Event>

    @POST("IRz9Lw/data")
    suspend fun createEvent(
        @Body event: Event
    ): Event

    @GET("IRz9Lw/data/{id}")
    suspend fun getEventById(
        @Path("id") id: Int
    ): Event

    @GET("IRz9Lw/data")
    suspend fun getEventByName(
        @Query("name") name: String
    )

}