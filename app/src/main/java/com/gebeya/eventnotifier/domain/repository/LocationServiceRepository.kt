package com.gebeya.eventnotifier.domain.repository

import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow

interface LocationServiceRepository {
    fun requestLocationUpdate(): Flow<LatLng?>
}