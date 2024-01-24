package com.gebeya.eventnotifier.data.network.entity

import com.google.gson.annotations.SerializedName

data class AuthenticationToken(
    val token: String,
    @SerializedName("expires_at")
    val expiresAt: String
)

data class User(
    val id: Int,
    val name: String
)
