package com.gebeya.eventnotifier.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

open class Address {
    var location_name: String = ""
    var phone_number: String = ""
}

@Entity(
    tableName = "events", indices = [Index(value = ["name", "type"], unique = true)],
    ignoredColumns = ["location_name"]
)
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "event_date") val date: String?,
    val name: String?,
    val type: String?,
    val location: String?,
    val tags: List<String>
): Address()
