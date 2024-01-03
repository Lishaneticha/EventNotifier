package com.gebeya.eventnotifier.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gebeya.eventnotifier.data.db.dao.EventDao
import com.gebeya.eventnotifier.data.db.dao.UserDao
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.User

@TypeConverters(TypeConverterRoom::class)
@Database(entities = [ Event::class, User::class ], version = 4)
abstract class AppDatabase: RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun userDao(): UserDao
}