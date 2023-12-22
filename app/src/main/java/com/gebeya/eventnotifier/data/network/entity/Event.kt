package com.gebeya.eventnotifier.data.network.entity

import com.google.gson.annotations.SerializedName

data class Event(
    val count: Int?,
    val location: String?,
    val entries: List<Entry>?
)

data class Entry(
    @SerializedName("API")
    val api: String?,
    val Description: String?,
    val test: String?
)