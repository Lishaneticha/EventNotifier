package com.gebeya.eventnotifier.ui

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.widget.ContentLoadingProgressBar
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gebeya.eventnotifier.ui.components.EventDatePicker
import com.gebeya.eventnotifier.viewmodel.WelcomeScreenViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import java.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WelcomeScreen(
    navToHomeScreen: () -> Unit,
    welcomeScreenViewModel: WelcomeScreenViewModel
){
    val welcomeScreenViewModel = hiltViewModel<WelcomeScreenViewModel>()
    val second by welcomeScreenViewModel.second.collectAsState()
    val location = welcomeScreenViewModel.location.collectAsState()

    println("location: ${location.value?.latitude} ${location.value?.longitude}")


    val context = LocalContext.current
    val mapType = remember { mutableStateOf(MapType.TERRAIN) }

    if(location.value != null){
        Box(modifier = Modifier.fillMaxSize()){
            val cameraPosition = rememberCameraPositionState()

            LaunchedEffect(location.value) {
                cameraPosition.centerCamera(location.value ?: LatLng(0.0, 0.0))
            }

            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPosition,
                properties = MapProperties(
                    mapType = mapType.value, isTrafficEnabled = true, isMyLocationEnabled = true
                )
            ) {
                Marker(state = MarkerState(location.value ?: LatLng(0.0, 0.0)),
                    title = "My position",
                    snippet = "This is my current location updated every 10 sec",
                    draggable = true,
                    onClick = {
                        println("Marker location: ${it.position}")
                        true
                    })

                Marker(
                    state = MarkerState(LatLng(8.997677611550133, 38.76446820795536)),
                    title = "FLamingo Cafe",
                    snippet = "This is a cafe near you"
                )

            }
            Column(
                modifier = Modifier.align(Alignment.CenterStart),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "${second}", color = Color.Black)
                Button(onClick = {
                    if (mapType.value == MapType.TERRAIN) {
                        mapType.value = MapType.SATELLITE
                    } else {
                        mapType.value = MapType.TERRAIN
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "",
                        tint = if(mapType.value == MapType.TERRAIN){ Color.Black } else{ Color.White }
                    )
                }
            }
        }
    }else{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){ CircularProgressIndicator() }
    }

}

suspend fun CameraPositionState.centerCamera( location: LatLng ){
    return animate(
        update = CameraUpdateFactory.newLatLngZoom( location, 15f ),
        durationMs = 2000
    )
}

fun check(): Boolean {
    TODO("I am waiting for API definition")
}