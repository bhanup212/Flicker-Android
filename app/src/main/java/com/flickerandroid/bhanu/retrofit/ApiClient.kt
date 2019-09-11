package com.flickerandroid.bhanu.retrofit

import com.flickerandroid.bhanu.BuildConfig
import com.flickerandroid.bhanu.model.Photo
import com.flickerandroid.bhanu.model.Photos
import com.flickerandroid.bhanu.model.Response
import com.flickerandroid.bhanu.retrofit.ApiService.okHttpClient
import com.google.gson.JsonObject
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by: Bhanu Prakash
 * Created on: 01,September,2019
 */

interface ApiClient{

    companion object{
        lateinit var retrofit: Retrofit

        val instance: ApiClient by lazy {
            val retro = Retrofit.Builder()
                .baseUrl(BuildConfig.FLICKER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
            retrofit = retro
            retrofit.create(ApiClient::class.java)
        }
    }



    @GET("/services/rest/?user_id=135487628%40N06")
    fun getAllPhotos(
        @Query("method") method:String = "flickr.people.getPublicPhotos",
        @Query("api_key") apiKey:String = "227be805b3d6e934926d049533bb938a",
        @Query("format") format:String = "json",
        @Query("nojsoncallback") callbackType:Int = 1
    ):Single<Response>


    @GET("/services/rest/?user_id=135487628%40N06")
    fun getPhotoDetails(
        @Query("method") method:String = "flickr.photos.getSizes",
        @Query("photo_id") photoId:String,
        @Query("api_key") apiKey:String = "227be805b3d6e934926d049533bb938a",
        @Query("format") format:String = "json",
        @Query("nojsoncallback") callbackType:Int = 1
    ):Single<Photo>



}

