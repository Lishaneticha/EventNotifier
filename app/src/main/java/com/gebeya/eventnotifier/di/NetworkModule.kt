package com.gebeya.eventnotifier.di

import com.gebeya.eventnotifier.data.network.api.EventApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideEvenApi(): EventApi{
        return Retrofit.Builder()
            .baseUrl("https://api.etnhis.org/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(EventApi::class.java)
    }

}