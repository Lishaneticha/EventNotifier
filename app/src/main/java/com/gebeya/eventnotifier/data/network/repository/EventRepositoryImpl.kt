package com.gebeya.eventnotifier.data.network.repository

import androidx.core.graphics.createBitmap
import com.gebeya.eventnotifier.data.network.api.EventApi
import com.gebeya.eventnotifier.data.network.entity.AuthenticationToken
import com.gebeya.eventnotifier.data.network.entity.Event
import com.gebeya.eventnotifier.data.network.entity.Location
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.PreferencesRepository
import com.gebeya.eventnotifier.domain.repository.Result
import com.google.gson.GsonBuilder
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import okhttp3.Credentials
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class EventRepositoryImpl(
    val eventApi: EventApi,
    val preferencesRepository: PreferencesRepository
): EventRepository {

    override suspend fun getEvent(): Result<List<Event>> {
        try{
            val result = eventApi.getEvent()
            println("network data: $result")
            return Result.Success(data = result)
        }catch (e: IOException){
            return Result.Fail(errorMessage = e.message ?: "")
        }catch (e: HttpException){
            return Result.Fail(errorMessage = e.message ?: "")
        }catch (t: Throwable){
            return Result.Fail(errorMessage = t.message ?: "")
        }

    }

    override suspend fun createEVent(event: Event): Event {
        return eventApi.createEvent(event = event)
    }

    override suspend fun getEventById(id: Int): Result<Event> {
        try{
            val data = eventApi.getEventById(id)
            return Result.Success(data = data)
        } catch (e: IOException){
            return Result.Fail(errorMessage = "Wifi connection is not enabled")
        } catch (e: HttpException){
            return Result.Fail(errorMessage = e.message ?: "")
        } catch (t: Throwable){
            return Result.Fail(errorMessage = t.message ?: "")
        }
    }

    override suspend fun updateEvent() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteEvent() {
        TODO("Not yet implemented")
    }

    override fun timer(): Flow<Int> {
        return callbackFlow {
            var i = 0
            while (true){
                i+=1
                trySend(i)
                delay(5000L)
            }
        }
    }

    override suspend fun login(): Result<AuthenticationToken> {
        try {
            val authorization = Credentials.basic("bole_02", "123456")
            val authenticationToken = eventApi.login(authorization)
            preferencesRepository.saveAuthenticationToken(authenticationToken)
            return Result.Success(data = authenticationToken)
        }catch (e: IOException){
            return Result.Fail(errorMessage = e.message ?: "no network")
        }catch (e: HttpException){
            return Result.Fail(errorMessage = e.message ?: "server error")
        }catch (e: Throwable){
            return Result.Fail(errorMessage = e.message ?: "unknown error")
        }
    }

    override suspend fun getLocations(): Result<List<Location>> {
        try {
            preferencesRepository.getAuthenticationToken()?.let {
                val locations = eventApi.getLocations("Token ${it.token}")
                return Result.Success(locations)
            }
            return Result.Fail("You need to login")
        }catch (e: IOException){
            return Result.Fail(errorMessage = e.message ?: "no network")
        }catch (e: HttpException){
            return Result.Fail(errorMessage = e.message ?: "server error")
        }catch (e: Throwable){
            return Result.Fail(errorMessage = e.message ?: "unknown error")
        }
    }
}