package com.gebeya.eventnotifier.data.db.repository

import com.gebeya.eventnotifier.data.db.dao.EventDao
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.Ticket
import com.gebeya.eventnotifier.data.db.entity.User
import com.gebeya.eventnotifier.data.db.entity.UserAndTicket
import com.gebeya.eventnotifier.domain.repository.EventDBRepository
import com.gebeya.eventnotifier.prettyPrint

class EventDBRepositoryImpl(
    val eventDao: EventDao
): EventDBRepository {
    override suspend fun insertAll(events: List<Event>, users: List<User>, tickets: List<Ticket>) {
        eventDao.insertAll(events, users, tickets)
    }

    override suspend fun getAll(): List<Event> {
        return eventDao.getAll()
    }

    override suspend fun getUserAndTicket(): List<UserAndTicket> {
        println("Event With Ticket: ${eventDao.getEventAndTicket()}")
        return eventDao.getUserAndTicket()
    }
}