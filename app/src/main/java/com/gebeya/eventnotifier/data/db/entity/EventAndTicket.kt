package com.gebeya.eventnotifier.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class EventAndTicket(
    @Embedded val event: Event,
    @Relation(
        parentColumn = "eventId",
        entityColumn = "eventId"
    )
    val tickets: List<Ticket>
)
