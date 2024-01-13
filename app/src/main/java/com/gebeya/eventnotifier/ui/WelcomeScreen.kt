package com.gebeya.eventnotifier.ui

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.core.widget.ContentLoadingProgressBar
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gebeya.eventnotifier.ui.components.EventDatePicker
import com.gebeya.eventnotifier.viewmodel.WelcomeScreenViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WelcomeScreen(
    navToHomeScreen: () -> Unit,
    welcomeScreenViewModel: WelcomeScreenViewModel
){
    val welcomeScreenViewModel = hiltViewModel<WelcomeScreenViewModel>()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        val context = LocalContext.current
        Text(text = "Welcome to Kotlin")

        EventDatePicker(
            eventDate = {
                Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
            }
        )

        EventDatePicker(
            eventDate = {
                Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
            }
        )

        Button(onClick = { navToHomeScreen() }) {
            Text(text = "continue")
        }
    }
}

fun check(): Boolean {
    TODO("I am waiting for API definition")
}