package com.gebeya.eventnotifier.data.db.repository

import com.gebeya.eventnotifier.data.db.dao.EventDao
import com.gebeya.eventnotifier.data.db.entity.EVentDateName
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.User
import com.gebeya.eventnotifier.domain.repository.EventDBRepository

class EventDBRepositoryImpl(
    val eventDao: EventDao
): EventDBRepository {
    override suspend fun insertAll(events: List<Event>, user: User) {
        eventDao.insertAll(events, user)
    }

    override suspend fun getAll(): List<Event> {
        return eventDao.getAll()
    }

    override suspend fun getEventByID(id: Int): EVentDateName {
        return eventDao.getEventByID(id)
    }
}