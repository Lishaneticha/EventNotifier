package com.gebeya.eventnotifier.ui

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.widget.ContentLoadingProgressBar
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gebeya.eventnotifier.ui.components.EventDatePicker
import com.gebeya.eventnotifier.viewmodel.WelcomeScreenViewModel
import java.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
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

        val isExpanded = remember{
            mutableStateOf(false)
        }

        val eventType = remember {
            mutableStateOf("")
        }


        val eventTypes = listOf("Conert", "Art Gallery", "Talent show")

        ExposedDropdownMenuBox(
            expanded = isExpanded.value,
            onExpandedChange = {
                isExpanded.value = it
            }
        ) {
            TextField(
                value = eventType.value,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded.value) },
                placeholder = { Text(text = "select event type")},
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpanded.value,
                onDismissRequest = { isExpanded.value = false }
            ) {
                eventTypes.forEach{
                    DropdownMenuItem(
                        text = { Text(text = it) },
                        onClick = {
                            isExpanded.value = false
                            eventType.value = it
                        }
                    )
                }
            }



        }

        Button(onClick = { navToHomeScreen() }) {
            Text(text = "continue")
        }
    }
}

fun check(): Boolean {
    TODO("I am waiting for API definition")
}