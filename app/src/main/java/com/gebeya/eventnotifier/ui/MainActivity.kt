package com.gebeya.eventnotifier.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gebeya.eventnotifier.data.network.api.EventApi
import com.gebeya.eventnotifier.data.network.entity.Event
import com.gebeya.eventnotifier.ui.theme.EventNotifierTheme
import com.gebeya.eventnotifier.viewmodel.WelcomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val welcomeScreenViewModel: WelcomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventNotifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EventApp(
                        welcomeScreenViewModel = welcomeScreenViewModel
                    )
                }
            }
        }
        welcomeScreenViewModel.insertAll()
        welcomeScreenViewModel.getAll()
        welcomeScreenViewModel.getEventByID(13)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventNotifierTheme {
        Greeting("Android")
    }
}
