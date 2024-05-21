package com.techtribeservices.jetpackplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techtribeservices.jetpackplayground.ui.theme.JetpackPlaygroundTheme

class Modifier_Layout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPlaygroundTheme {
                ModifierLayout()
            }
        }
    }
}

@Composable
fun ModifierLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            //.padding(start = 40.dp, top=140.dp)
            .verticalScroll(rememberScrollState())
            .border(12.dp, Color.Green)
            .padding(horizontal = 20.dp, vertical = 40.dp),

    ) {
        Button(
            modifier = Modifier
                .offset(20.dp, 100.dp)
                .padding(start = 20.dp),
            onClick = { /*TODO*/ }) {
            Text(text="Button 1")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text="Button 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierLayoutPreview() {
    JetpackPlaygroundTheme {
        ModifierLayout()
    }
}