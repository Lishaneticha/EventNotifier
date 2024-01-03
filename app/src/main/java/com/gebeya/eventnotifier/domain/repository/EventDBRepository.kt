package com.gebeya.eventnotifier.domain.repository

import com.gebeya.eventnotifier.data.db.dao.EventDao
import com.gebeya.eventnotifier.data.db.entity.EVentDateName
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.data.db.entity.User

interface EventDBRepository {
    suspend fun insertAll(events: List<Event>, user: User)
    suspend fun getAll(): List<Event>
    suspend fun getEventByID(id: Int): EVentDateName
}