package com.gebeya.eventnotifier

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventApp(){

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Event") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = ""
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.AccountBox,
                        contentDescription = ""
                    )
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {

            NavHost(navController = navController, startDestination = "welcome screen" ){
                composable(route = "welcome screen"){
                    WelcomeScreen(
                        navToHomeScreen = {
                            navController.navigate("home screen")
                        }
                    )
                }

                composable(route = "home screen"){
                    HomeScreen()
                }

                composable(route = "add screen"){
                    AddEventScreen()
                }
            }


        }
    }
//
//    AddEventScreen()
}