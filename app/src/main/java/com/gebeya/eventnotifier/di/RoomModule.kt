package com.gebeya.eventnotifier.di

import android.app.Application
import androidx.room.Room
import com.gebeya.eventnotifier.data.db.AppDatabase
import com.gebeya.eventnotifier.data.db.dao.EventDao
import com.gebeya.eventnotifier.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase{
        return Room.databaseBuilder(
            context = app,
            klass = AppDatabase::class.java,
            name = "event_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideEventDao(appDatabase: AppDatabase): EventDao{
        return appDatabase.eventDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao{
        return appDatabase.userDao()
    }

}