package com.gebeya.eventnotifier.di

import com.gebeya.eventnotifier.data.network.api.EventApi
import com.gebeya.eventnotifier.data.network.repository.EventRepositoryImpl
import com.gebeya.eventnotifier.domain.repository.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideEventRepository(eventApi: EventApi): EventRepository{
        return EventRepositoryImpl(eventApi)
    }

}