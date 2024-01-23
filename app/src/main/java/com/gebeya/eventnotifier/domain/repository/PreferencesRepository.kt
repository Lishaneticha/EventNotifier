package com.gebeya.eventnotifier.domain.repository

import com.gebeya.eventnotifier.data.network.entity.AuthenticationToken

interface PreferencesRepository {
    fun saveAuthenticationToken(authenticationToken: AuthenticationToken)
    fun getAuthenticationToken(): AuthenticationToken?
}