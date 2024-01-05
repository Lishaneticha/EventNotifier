package com.gebeya.eventnotifier.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "events", indices = [Index(value = ["name", "type"], unique = true)]
)
data class Event(
    @PrimaryKey(autoGenerate = true) val eventId: Int = 0,
    @ColumnInfo(name = "event_date") val date: String?,
    val name: String?,
    val type: String?,
    val location: String?,
    val tags: List<String>
)
