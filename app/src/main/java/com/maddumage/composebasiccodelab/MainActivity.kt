package com.maddumage.composebasiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maddumage.composebasiccodelab.ui.theme.ComposeBasicCodelabTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier
) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    if(shouldShowOnboarding){
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    }else{
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    ComposeBasicCodelabTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("Android", "Flutter", "React Native")
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name)
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingsPreview() {
    ComposeBasicCodelabTheme {
        Greetings()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expanded) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(
                    text = "Hello",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(600)
                )
                Text(
                    text = "$name!",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(600)
                )
            }
            ElevatedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show more" else "Show less")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicCodelabTheme {
        MyApp()
    }
}

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeBasicCodelabTheme {
        OnboardingScreen(onContinueClicked = {}) // Do nothing on click.
    }
}