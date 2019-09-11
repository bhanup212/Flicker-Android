package com.flickerandroid.bhanu.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.flickerandroid.bhanu.model.Photo
import com.flickerandroid.bhanu.model.Photos
import com.flickerandroid.bhanu.model.Response
import com.flickerandroid.bhanu.retrofit.ApiClient
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Created by: Bhanu Prakash
 * Created on: 01,September,2019
 */
class FlickerViewModel : ViewModel() {

    private val TAG = FlickerViewModel::class.java.simpleName
    val isDataLoading = MutableLiveData<Boolean>()
    var photos: MutableLiveData<ArrayList<Photo>> = MutableLiveData()
    var photoList = ArrayList<Photo>()
    private val disaposable:CompositeDisposable = CompositeDisposable()

    fun loadAllPhotos(){
        isDataLoading.value = true
        disaposable.add(
            ApiClient.instance.getAllPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<Response>() {
                    override fun onSuccess(t: Response) {
                        for (photo in t.photos.photoList){
                            getPhotoDetails(photoId = photo.id)
                        }
                        photos.postValue(photoList)
                        photos.value?.addAll(photoList)
                        isDataLoading.value = false

                    }

                    override fun onError(e: Throwable) {
                        isDataLoading.value = false
                        Log.e(TAG,"error: ${e.message}")
                    }

                })
        )

    }

    fun getPhotoDetails(photoId:String){
        disaposable.add(
            ApiClient.instance.getPhotoDetails(photoId = photoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableSingleObserver<Photo>(){
                    override fun onSuccess(t: Photo) {
                        photoList.add(t)
                    }


                    override fun onError(e: Throwable) {
                        Log.e(TAG,"error2: ${e.message}")

                    }

                })
        )

    }
}