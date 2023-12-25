package com.gebeya.eventnotifier.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.core.widget.ContentLoadingProgressBar
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gebeya.eventnotifier.viewmodel.WelcomeScreenViewModel

@Composable
fun WelcomeScreen(
    navToHomeScreen: () -> Unit,
    welcomeScreenViewModel: WelcomeScreenViewModel
){

    welcomeScreenViewModel.getEvent()
    welcomeScreenViewModel.getEventById(1)
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Welcome to Kotlin")

        if(welcomeScreenViewModel.eventList.isNotEmpty()){
            welcomeScreenViewModel.eventList.forEach {
                Text(text = it.name ?: "")
            }
        }else{
            Text(text = "Loading ..")
            LinearProgressIndicator()
            CircularProgressIndicator()
        }

        Text(text = welcomeScreenViewModel.event?.name ?: "")
        Text(text = welcomeScreenViewModel.event?.date ?: "")
        Text(text = welcomeScreenViewModel.event?.location ?: "")
        Text(text = welcomeScreenViewModel.event?.type ?: "")

        Button(onClick = { navToHomeScreen() }) {
            Text(text = "continue")
        }
    }
}

fun check(): Boolean {
    TODO("I am waiting for API definition")
}