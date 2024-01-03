package com.gebeya.eventnotifier.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.gebeya.eventnotifier.data.db.entity.EVentDateName
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.EventWithUser
import com.gebeya.eventnotifier.data.db.entity.User

@Dao
interface EventDao {
    @Insert
    suspend fun insert(event: Event)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(events: List<Event>, user: User)

    @Query("select * from events")
    suspend fun getAll(): List<Event>

    @Query("SELECT event_date, name FROM events where id = :id")
    suspend fun getEventByID(id: Int): EVentDateName


    @Query("select events.name as event_name, user.first_name as user_name from events " +
            "join user on events.id = user.event_id")
    suspend fun getEventWithUser(): EventWithUser

    @Update
    suspend fun update(event: Event)

    @Delete
    suspend fun deleteUser(user: User)

    @Delete
    suspend fun deleteEvent(event: Event)

    @Transaction
    suspend fun deleteFromEventAndUser(event: Event, user: User){
        deleteEvent(event)
        deleteUser(user)
    }
}