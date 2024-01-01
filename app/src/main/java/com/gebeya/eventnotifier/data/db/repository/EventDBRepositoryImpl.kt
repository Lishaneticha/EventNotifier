package com.gebeya.eventnotifier.data.db.repository

import com.gebeya.eventnotifier.data.db.dao.EventDao
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.domain.repository.EventDBRepository

class EventDBRepositoryImpl(
    val eventDao: EventDao
): EventDBRepository {
    override suspend fun insertAll(events: List<Event>) {
        eventDao.insertAll(events)
    }
}