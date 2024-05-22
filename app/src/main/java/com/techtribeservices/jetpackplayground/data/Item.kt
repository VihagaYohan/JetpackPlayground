package com.techtribeservices.jetpackplayground.data

import androidx.annotation.DrawableRes

data class Item(
    val title: String,
    @DrawableRes val image: Int
) {

}