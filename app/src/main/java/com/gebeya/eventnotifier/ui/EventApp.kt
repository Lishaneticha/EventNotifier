package com.gebeya.eventnotifier.ui

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gebeya.eventnotifier.viewmodel.WelcomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventApp(
    welcomeScreenViewModel: WelcomeScreenViewModel
){

    val navController = rememberNavController()
    val canNavBack = remember{ mutableStateOf(false)}
    val currentScreen = navController.currentBackStackEntryAsState().value?.destination?.route?.split("/")?.get(0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentScreen ?: "Event") }, //if(currentScreen == null) "Event" else currentScreen
                navigationIcon = {
                    if(canNavBack.value == true){
                        Icon(
                            modifier = Modifier.clickable { navController.navigateUp() },
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = ""
                        )
                    }
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
                    canNavBack.value = navController.previousBackStackEntry != null

                    WelcomeScreen(
                        navToHomeScreen = {
                            navController.navigate("home screen")
                        },
                        welcomeScreenViewModel = welcomeScreenViewModel
                    )
                }

                composable(route = "home screen"){ backStackEntry ->

                    canNavBack.value = navController.previousBackStackEntry != null
                    HomeScreen(
                        viewDetail = { id ->
                            navController.navigate("detail screen/$id")
                        }
                    )
                }

                composable(route = "add screen"){
                    canNavBack.value = navController.previousBackStackEntry != null
                    AddEventScreen()
                }

                composable(route = "detail screen/{id}"){
                    val id = it.arguments?.getString("id")
                    DetailScreen(
                        id = id?.toInt() ?: 0
                    )
                }
            }


        }
    }
//
//    AddEventScreen()

    val p1: Persons
}



class Persons(
    val name: String,
    val age: Int
)

