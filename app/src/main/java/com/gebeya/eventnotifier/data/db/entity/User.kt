package com.gebeya.eventnotifier.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val first_name: String?,
    val last_name: String?
)
