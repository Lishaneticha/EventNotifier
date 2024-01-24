package com.gebeya.eventnotifier.data.SharedPreferences

import android.app.Application
import android.preference.PreferenceManager
import com.gebeya.eventnotifier.data.network.entity.AuthenticationToken
import com.gebeya.eventnotifier.domain.repository.PreferencesRepository
import com.google.gson.Gson

class PreferencesRepositoryImpl(
    application: Application
): PreferencesRepository {

    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)
    val gson = Gson()

    override fun saveAuthenticationToken(authenticationToken: AuthenticationToken) {
        val tokenJson = gson.toJson(authenticationToken)
        println("Login result json: $tokenJson")
        sharedPreferences.edit().putString("authentication_token",tokenJson).apply()
    }

    override fun getAuthenticationToken(): AuthenticationToken? {
        val tokenJson = sharedPreferences.getString("authentication_token", null)
        if(tokenJson != null){
            return gson.fromJson(tokenJson, AuthenticationToken::class.java)
        }else{
            return null
        }
    }
}