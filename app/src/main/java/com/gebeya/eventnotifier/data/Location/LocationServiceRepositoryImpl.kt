package com.gebeya.eventnotifier.data.Location

import android.annotation.SuppressLint
import android.os.Looper
import com.gebeya.eventnotifier.domain.repository.LocationServiceRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class LocationServiceRepositoryImpl(
    val locationProviderClient: FusedLocationProviderClient
): LocationServiceRepository {
    @SuppressLint("MissingPermission")
    override fun requestLocationUpdate(): Flow<LatLng?> {
        return callbackFlow {

            val locationSetting = LocationRequest.Builder(5000L)
                .setIntervalMillis(10000L)
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
                .build()
            val locationCallBack = object : LocationCallback(){
                override fun onLocationResult(locationResult: LocationResult) {
                    locationResult.locations.lastOrNull()?.let {
                        trySend(LatLng(it.latitude, it.longitude))
                    }
                }
            }

            locationProviderClient.requestLocationUpdates(
                locationSetting,
                locationCallBack,
                Looper.getMainLooper()
            )

            awaitClose {
                locationProviderClient.removeLocationUpdates(locationCallBack)
            }

        }
    }
}