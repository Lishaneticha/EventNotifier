package com.gebeya.eventnotifier.data.network.api

import com.gebeya.eventnotifier.data.network.entity.AuthenticationToken
import com.gebeya.eventnotifier.data.network.entity.Event
import com.gebeya.eventnotifier.data.network.entity.Location
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

const val AUTHORIZATION = "Authorization"

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

    @POST("authentication_token")
    suspend fun login(
        @Header(AUTHORIZATION) authorization: String
    ): AuthenticationToken

    @GET("administrative_divisions")
    suspend fun getLocations(
        @Header(AUTHORIZATION) token: String
    ): List<Location>

}