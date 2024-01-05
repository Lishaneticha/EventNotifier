package com.gebeya.eventnotifier.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.EventAndTicket
import com.gebeya.eventnotifier.data.db.entity.Ticket
import com.gebeya.eventnotifier.data.db.entity.User
import com.gebeya.eventnotifier.data.db.entity.UserAndTicket

@Dao
interface EventDao {
    @Insert
    suspend fun insert(event: Event)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(events: List<Event>, users: List<User>, tickets: List<Ticket>)

    @Query("select * from events")
    suspend fun getAll(): List<Event>

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

    @Transaction
    @Delete
    suspend fun deletFromUserAndEvent(event: Event, user: User, ticket: Ticket)

    @Transaction
    @Query("select * from user")
    suspend fun getUserAndTicket(): List<UserAndTicket>

    @Transaction
    @Query("select * from events")
    suspend fun getEventAndTicket(): List<EventAndTicket>
}