package com.gebeya.eventnotifier.domain.repository

import com.gebeya.eventnotifier.data.db.entity.Event

interface EventDBRepository {
    suspend fun insertAll(events: List<Event>)
}