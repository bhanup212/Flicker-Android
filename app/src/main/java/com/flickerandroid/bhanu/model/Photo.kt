package com.flickerandroid.bhanu.model

import com.google.gson.annotations.SerializedName

/**
 * Created by: Bhanu Prakash
 * Created on: 01,September,2019
 */
data class Photo(
    @SerializedName("id")
    val id:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("sizes")
    val size: Sizes


){
data class Sizes(
    @SerializedName("size")
    val size:ArrayList<PhotoSize>
)
}