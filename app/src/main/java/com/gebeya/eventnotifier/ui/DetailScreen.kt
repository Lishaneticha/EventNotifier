package com.gebeya.eventnotifier.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gebeya.eventnotifier.R
import com.gebeya.eventnotifier.domain.repository.Result
import com.gebeya.eventnotifier.viewmodel.DetailScreenViewModel

@Composable
fun DetailScreen(
    id: Int
){
    val detailScreenViewModel = hiltViewModel<DetailScreenViewModel>()
    val eventDetail by detailScreenViewModel.eventDetail.collectAsState(initial = null)

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(eventDetail){
                is Result.Fail -> {
                    Text(
                        text = eventDetail?.errorMessage ?: "",
                        color = Color(0xFFFF0000),
                        fontWeight = FontWeight.Bold
                    )
                }
                is Result.Success -> {
                    Image(
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(shape = CircleShape)
                            .border(
                                width = 2.dp, color = Color.White, shape = CircleShape
                            ),
                        painter = painterResource(id = R.drawable.event_ph),
                        contentDescription = "placeholder"
                    )

                    DetailScreenRow(
                        text1 = stringResource(id = R.string.name),
                        text2 = eventDetail?.data?.name ?: "N/A"
                    )
                    DetailScreenRow(
                        text1 = stringResource(id = R.string.location),
                        text2 = eventDetail?.data?.location ?: "N/A"
                    )
                    DetailScreenRow(
                        text1 = stringResource(id = R.string.type),
                        text2 = eventDetail?.data?.type ?: "N/A"
                    )
                    DetailScreenRow(
                        text1 = stringResource(id = R.string.date),
                        text2 = eventDetail?.data?.date ?: "N/A"
                    )
                }
                null -> {
                    LinearProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun DetailScreenRow(
    text1: String,
    text2: String
){
    Row(
        modifier  = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text1,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = text2,
            textAlign = TextAlign.Left
        )
    }
}

@Preview
@Composable
fun DisplayDetailScreen(){
    DetailScreen(0)
}