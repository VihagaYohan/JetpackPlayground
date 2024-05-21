package com.techtribeservices.jetpackplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techtribeservices.jetpackplayground.ui.theme.JetpackPlaygroundTheme

class Row_Column : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPlaygroundTheme {

            }
        }
    }
}

@Composable
fun RowLayout() {
    Row {
        Button(onClick = { /*TODO*/ }) {
            Text(text="Button 1")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text="Button 2")
        }
    }
}

@Composable
fun ColumnLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.secondary),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = {}) {
            Text(text="Button 1")
        }

        Button(

            onClick = {}) {
            Text(text="Button 2")
        }

        Button(onClick = {}) {
            Text(text="Button 3")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutPreview() {
    JetpackPlaygroundTheme {
        ColumnLayout()
    }
}



