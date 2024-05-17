package com.maddumage.composebasiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.maddumage.composebasiccodelab.ui.theme.ComposeBasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicCodelabTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.White) { innerPadding ->
                    Greeting(
                        name = "Welcome to My First Compose App",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight(600)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicCodelabTheme {
        Greeting("Welcome to My First Compose App")
    }
}