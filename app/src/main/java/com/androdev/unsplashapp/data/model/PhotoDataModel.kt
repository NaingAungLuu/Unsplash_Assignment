package com.androdev.unsplashapp.data.model

import androidx.lifecycle.LiveData
import com.androdev.unsplashapp.data.vos.PhotoVO

interface PhotoDataModel {

    fun getPhotoList(onFailure : (String) -> Unit):LiveData<List<PhotoVO>>
    fun getPhotoByID(photoID : String):LiveData<PhotoVO>

}