package com.gebeya.eventnotifier.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Address(
    val city: String?,
    val subcity: String?,
    val street: String?,
    val postcode: Int?
)

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val first_name: String?,
    val last_name: String?,
    val event_id: Int,
    @ColumnInfo(name = "phone_number") val phone: String,
    @Embedded val address: Address

)
