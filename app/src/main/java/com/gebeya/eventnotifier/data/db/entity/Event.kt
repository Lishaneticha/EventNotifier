package com.gebeya.eventnotifier.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "events", indices = [Index(value = ["name", "type"], unique = true)])
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String?,
    val name: String?,
    val type: String?,
    val location: String?
)
