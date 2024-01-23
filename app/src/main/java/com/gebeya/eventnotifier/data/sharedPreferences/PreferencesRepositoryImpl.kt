package com.gebeya.eventnotifier.data.sharedPreferences

import android.app.Application
import android.preference.PreferenceManager
import com.gebeya.eventnotifier.data.network.entity.AuthenticationToken
import com.gebeya.eventnotifier.domain.repository.PreferencesRepository
import com.google.gson.Gson

class PreferencesRepositoryImpl(
    val application: Application
): PreferencesRepository {

    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)
    val gson = Gson()
    override fun saveAuthenticationToken(authenticationToken: AuthenticationToken) {
        sharedPreferences.edit().putString("authentication_token", gson.toJson(authenticationToken)).apply()
    }

    override fun getAuthenticationToken(): AuthenticationToken? {
        val tokenJson = sharedPreferences.getString("authentication_token", null)
        return if(tokenJson == null){
            null
        }else{
            gson.fromJson(tokenJson, AuthenticationToken::class.java)
        }
    }
}