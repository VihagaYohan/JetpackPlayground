package com.techtribeservices.jetpackplayground

import android.os.Bundle
import androidx.compose.ui.Modifier
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techtribeservices.jetpackplayground.ui.theme.JetpackPlaygroundTheme


class State_Handle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent() {
            JetpackPlaygroundTheme {
                Screen()
            }
        }
    }
}

@Composable
fun Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val textVisibility = remember{
            mutableStateOf(true)
        }

        val text = if(textVisibility.value) "Visible Text" else "Not Visible Text"

        Text(
            modifier = Modifier
                .alpha(if(textVisibility.value) 1f else 0.3f),
            text = text
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            textVisibility.value = !textVisibility.value
        }) {
            Text(text = "Show Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenLayoutPreview() {
    JetpackPlaygroundTheme {
        Screen()
    }
}