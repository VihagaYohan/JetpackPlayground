package com.techtribeservices.jetpackplayground

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techtribeservices.jetpackplayground.ui.theme.JetpackPlaygroundTheme

class TextField_Layout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent() {
            JetpackPlaygroundTheme {
                TextFieldLayout()
            }
        }
    }
}

@Composable
fun TextFieldLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val textInput = remember {
            mutableStateOf("")
        }
        TextField(
            value = textInput.value,
            onValueChange = {newText ->
                textInput.value = newText
            }, 
            label = {
                Text(text = "Name")
            },
            placeholder = {
                Text(text = "Enter your name")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search icon"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "clear icon"
                )
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp),
            value = textInput.value,
            onValueChange = {
                textInput.value = it
            },
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 18.sp
            ),
            decorationBox = {innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if(textInput.value.isEmpty()) {
                            Text(
                                text="Search",
                                color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
                        }
                        innerTextField()
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    if(!textInput.value.isEmpty()) {
                        Icon(
                            modifier = Modifier
                                .clickable {
                                    textInput.value = ""
                                },
                            imageVector = Icons.Default.Clear, contentDescription = "")
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    JetpackPlaygroundTheme {
        TextFieldLayout()
    }
}