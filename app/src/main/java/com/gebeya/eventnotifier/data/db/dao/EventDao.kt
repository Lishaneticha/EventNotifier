package com.gebeya.eventnotifier.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gebeya.eventnotifier.data.db.entity.Event

@Dao
interface EventDao {
    @Insert
    suspend fun insert(event: Event)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(events: List<Event>)

    @Query("select * from events")
    suspend fun getAll(): List<Event>

    @Update
    suspend fun update(event: Event)
}