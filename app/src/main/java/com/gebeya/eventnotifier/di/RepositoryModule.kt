package com.gebeya.eventnotifier.di

import android.app.Application
import com.gebeya.eventnotifier.data.db.dao.EventDao
import com.gebeya.eventnotifier.data.db.repository.EventDBRepositoryImpl
import com.gebeya.eventnotifier.data.network.api.EventApi
import com.gebeya.eventnotifier.data.network.repository.EventRepositoryImpl
import com.gebeya.eventnotifier.data.sharedPreferences.PreferencesRepositoryImpl
import com.gebeya.eventnotifier.domain.repository.EventDBRepository
import com.gebeya.eventnotifier.domain.repository.EventRepository
import com.gebeya.eventnotifier.domain.repository.PreferencesRepository
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
    fun provideEventRepository(eventApi: EventApi, preferencesRepository: PreferencesRepository): EventRepository{
        return EventRepositoryImpl(eventApi, preferencesRepository)
    }

    @Provides
    @Singleton
    fun provideEventDBRepository(eventDao: EventDao): EventDBRepository{
        return EventDBRepositoryImpl(eventDao)
    }

    @Provides
    @Singleton
    fun providePreferencesRepository(application: Application): PreferencesRepository{
        return PreferencesRepositoryImpl(application)
    }

}