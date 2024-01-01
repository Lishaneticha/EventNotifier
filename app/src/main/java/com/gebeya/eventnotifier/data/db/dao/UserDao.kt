package com.gebeya.eventnotifier.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.gebeya.eventnotifier.data.db.entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
}