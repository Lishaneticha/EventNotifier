package com.gebeya.eventnotifier.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity
data class Ticket(
    @PrimaryKey(autoGenerate = true) val ticketId: Int = 0,
    val startDate: Instant,
    val endDate: Instant,
    val sold: Boolean,
    val userId: Int,
    val eventId: Int
)
