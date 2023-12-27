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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.gebeya.eventnotifier.R

@Composable
fun DetailScreen(){
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

            Row(
                modifier  = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.name),
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = "music concert",
                    textAlign = TextAlign.Left
                )
            }
        }
    }
}

@Preview
@Composable
fun DisplayDetailScreen(){
    DetailScreen()
}