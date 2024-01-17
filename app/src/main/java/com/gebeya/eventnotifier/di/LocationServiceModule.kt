package com.gebeya.eventnotifier.di

import android.app.Application
import com.gebeya.eventnotifier.data.Location.LocationServiceRepositoryImpl
import com.gebeya.eventnotifier.domain.repository.LocationServiceRepository
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationServiceModule {

    @Singleton
    @Provides
    fun provideLocationServiceRepository(app: Application): LocationServiceRepository{
        return LocationServiceRepositoryImpl(
            LocationServices.getFusedLocationProviderClient(app)
        )
    }

}