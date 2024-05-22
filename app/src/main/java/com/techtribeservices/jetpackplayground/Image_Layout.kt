package com.techtribeservices.jetpackplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.techtribeservices.jetpackplayground.ui.theme.JetpackPlaygroundTheme

class Image_Layout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPlaygroundTheme {
                ImageLayout()
            }
        }
    }
}

@Composable
fun ImageLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = R.drawable.local_image),
            contentDescription = "local image")

        Spacer(modifier = Modifier.height(15.dp))

        val imageUrl = "https://unsplash.com/photos/landscape-photography-of-mountain-hit-by-sun-rays-78A265wPiO4"

        val model = ImageRequest
            .Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .build()
        
        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp)),
            model = model,
            contentDescription = "remote image",)
        
        val imageState = rememberAsyncImagePainter(model = model).state

        Box(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            if(imageState is AsyncImagePainter.State.Success) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = imageState.painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            if(imageState is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            if(imageState is AsyncImagePainter.State.Error) {
                Icon(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center),
                    imageVector = Icons.Rounded.ImageNotSupported,
                    contentDescription = null)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageLayoutPreview() {
    JetpackPlaygroundTheme {
        ImageLayout()
    }
}