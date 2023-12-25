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
    val currentScreen = navController.currentBackStackEntryAsState().value?.destination?.route

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
                            navController.navigate("home screen?name=Abel?age=12")
                        },
                        welcomeScreenViewModel = welcomeScreenViewModel
                    )
                }

                composable(
                    route = "home screen?name={name}?age={age}",
                    arguments = listOf(
                        navArgument("name"){
                            defaultValue = "test"
                        },
                        navArgument("age"){
                            defaultValue = 0
                            type = NavType.IntType
                        }
                    )
                ){ backStackEntry ->

                    val name = backStackEntry.arguments?.getString("name")
                    val age = backStackEntry.arguments?.getInt("age")

                    canNavBack.value = navController.previousBackStackEntry != null
                    HomeScreen(
                        name = name,
                        age = age
                    )
                }

                composable(route = "add screen"){
                    canNavBack.value = navController.previousBackStackEntry != null
                    AddEventScreen()
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

