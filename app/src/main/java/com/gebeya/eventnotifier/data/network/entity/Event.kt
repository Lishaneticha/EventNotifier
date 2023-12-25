package com.gebeya.eventnotifier.data.network.entity

import com.google.gson.annotations.SerializedName

data class Event(
    val date: String?,
    val name: String?,
    val type: String?,
    val location: String?
)