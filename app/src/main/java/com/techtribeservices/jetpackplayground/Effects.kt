package com.techtribeservices.jetpackplayground

import android.os.Bundle
import android.text.Layout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techtribeservices.jetpackplayground.data.MyViewModel
import com.techtribeservices.jetpackplayground.ui.theme.JetpackPlaygroundTheme

class Effects : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPlaygroundTheme {
                EffectHandler()
            }
        }
    }
}

@Composable
fun EffectHandler(myViewModal: MyViewModel = viewModel()) {
    val nameState by myViewModal.nameState.collectAsState()

    LaunchedEffect(key1 = true) {
        myViewModal.loadName()
    }



    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        //Text(text = nameState)
    }
}