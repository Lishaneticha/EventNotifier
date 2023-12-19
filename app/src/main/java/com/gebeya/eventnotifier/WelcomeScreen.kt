package com.gebeya.eventnotifier

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreen(
    navToHomeScreen: () -> Unit
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Welcome to Kotlin")
        Button(onClick = { navToHomeScreen() }) {
            Text(text = "continue")
        }
    }
}

fun check(): Boolean {
    TODO("I am waiting for API definition")
}