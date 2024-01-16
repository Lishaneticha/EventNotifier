package com.gebeya.eventnotifier.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gebeya.eventnotifier.ui.components.EventCard
import com.gebeya.eventnotifier.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewDetail: (id: Int) -> Unit
){
    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        if (homeScreenViewModel.eventList.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(homeScreenViewModel.eventList) {
                    EventCard(
                        id = it.id,
                        name = it.name ?: "",
                        location = it.location ?: "",
                        date = it.date ?: "",
                        viewDetail = { id ->
                            viewDetail(id)
                        }
                    )
                }
            }
        } else {
            LinearProgressIndicator()
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun displayHomeScreen(){
    HomeScreen({})
}
