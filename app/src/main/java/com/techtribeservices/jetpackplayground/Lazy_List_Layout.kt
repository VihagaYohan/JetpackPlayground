package com.techtribeservices.jetpackplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techtribeservices.jetpackplayground.data.Item
import com.techtribeservices.jetpackplayground.ui.theme.JetpackPlaygroundTheme

class Lazy_List_Layout : ComponentActivity() {
    companion object {
        val items: List<Item> = listOf(
            Item(title = "item 1", image = R.drawable.local_image),
            Item(title = "item 2", image = R.drawable.local_image),
            Item(title = "item 3", image = R.drawable.local_image),
            Item(title = "item 4", image = R.drawable.local_image),
            Item(title = "item 5", image = R.drawable.local_image),
            Item(title = "item 6", image = R.drawable.local_image)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPlaygroundTheme {
                LazyGridLayout()
            }
        }
    }
}

@Composable
fun LazyRowLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(10.dp)
        ) {
           items(Lazy_List_Layout.items) {item ->
               Spacer(modifier = Modifier.width(8.dp))
               RowItem(item = item)
               Spacer(modifier = Modifier.width(8.dp))
           }
        }
    }
}

@Composable
fun LazyColumnLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(Lazy_List_Layout.items) {item ->
                Spacer(modifier = Modifier.height(8.dp))
                RowItem(item = item)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun LazyGridLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(vertical = 10.dp, horizontal = 5.dp),
            columns = GridCells.Fixed(2)
        ) {
            itemsIndexed(Lazy_List_Layout.items) {index, item ->
                RowItem(item = item)
                // Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun RowItem(item: Item) {
    Column(
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .height(150.dp),
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop
        )
        
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = item.title,
            fontWeight = FontWeight.SemiBold
        )
    }
}



@Preview(showBackground = true)
@Composable
fun ListLayoutPreview() {
    JetpackPlaygroundTheme {
        LazyRowLayout()
    }
}