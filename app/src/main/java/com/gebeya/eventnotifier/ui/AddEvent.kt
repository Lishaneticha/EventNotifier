package com.gebeya.eventnotifier.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gebeya.eventnotifier.data.db.entity.Event
import com.gebeya.eventnotifier.ui.components.EventDatePicker
import com.gebeya.eventnotifier.viewmodel.AddEventViewmodel
import java.time.Instant

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventScreen(){

    val addEventViewModel = hiltViewModel<AddEventViewmodel>()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Add event screen",
            fontSize = 30.sp,
            color = Color(0xFF5E69FF), //AARRGGBB
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 10.sp,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        val isExpanded = remember{
            mutableStateOf(false)
        }

        val eventType = remember {
            mutableStateOf("")
        }

        val eventDate = remember {
            mutableStateOf(Instant.now())
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
                isError = addEventViewModel.nameError.value.isNotEmpty(),
                supportingText = { Text(text = addEventViewModel.nameError.value) },
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

        EventDatePicker(
            eventDate = {
                eventDate.value = it
            }
        )

        Button(
            onClick = {
                addEventViewModel.validateInput("", eventType.value, eventDate.value)
                if(
                    addEventViewModel.nameError.value.isEmpty() &&
                    addEventViewModel.typeError.value.isEmpty()
                    ){
                    addEventViewModel.insertEvent(
                        Event(
                            date = eventDate.value,
                            name = "Music concert",
                            type = eventType.value,
                            location = "",
                            tags = listOf()
                        )
                    )
                }
            }
        ) {
            Text(text = "save")
        }


    }
}