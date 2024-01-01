package com.gebeya.eventnotifier.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gebeya.eventnotifier.data.db.dao.EventDao
import com.gebeya.eventnotifier.data.db.dao.UserDao
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.User

@Database(entities = [ Event::class, User::class ], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun userDao(): UserDao
}