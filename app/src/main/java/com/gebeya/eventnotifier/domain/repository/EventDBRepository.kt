package com.gebeya.eventnotifier.domain.repository

import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.Ticket
import com.gebeya.eventnotifier.data.db.entity.User
import com.gebeya.eventnotifier.data.db.entity.UserAndTicket

interface EventDBRepository {
    suspend fun insertAll(events: List<Event>, users: List<User>, tickets: List<Ticket>)
    suspend fun getAll(): List<Event>
    suspend fun insertEvent(event: Event)
    suspend fun getUserAndTicket(): List<UserAndTicket>
}