package com.flickerandroid.bhanu.model

import com.google.gson.annotations.SerializedName

/**
 * Created by: Bhanu Prakash
 * Created on: 01,September,2019
 */
data class Photos(
    @SerializedName("total")
    val total:Int,
    @SerializedName("photo")
    val photoList:ArrayList<Photo>
)