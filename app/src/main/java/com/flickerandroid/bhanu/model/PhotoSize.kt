package com.flickerandroid.bhanu.model

import com.google.gson.annotations.SerializedName

/**
 * Created by: Bhanu Prakash
 * Created on: 01,September,2019
 */
data class PhotoSize(
    @SerializedName("label")
    val label:String,
    @SerializedName("width")
    val width:Int,
    @SerializedName("height")
    val height:Int,
    @SerializedName("source")
    val source:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("media")
    val media:String
)