package com.techtribeservices.jetpackplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import com.techtribeservices.jetpackplayground.ui.theme.JetpackPlaygroundTheme
import com.techtribeservices.jetpackplayground.ui.theme.poppins_medimum
import com.techtribeservices.jetpackplayground.ui.theme.poppins_regular

class Text_Layout : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPlaygroundTheme {
                TextLayout()
            }
        }
    }
}

@Composable
fun TextLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))

        val shadowOffset = Offset(x = 4f, y = 10f)

        Text(
            //text = "Some text is written here some text is written here some text written here some text written here",
            text = buildAnnotatedString {
              append("Text is")
                withStyle(
                    SpanStyle(
                        color = Color.Red,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 30.sp
                    )
                ) {
                    append(" written")
                }
            },
            color = MaterialTheme.colorScheme.primary,
            fontFamily = poppins_medimum,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray,
                    offset = shadowOffset,
                    blurRadius = 9f
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextLayoutPreview() {
    JetpackPlaygroundTheme {
        TextLayout()
    }
}