package com.gebeya.eventnotifier.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndTicket(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val ticket: Ticket?
)
