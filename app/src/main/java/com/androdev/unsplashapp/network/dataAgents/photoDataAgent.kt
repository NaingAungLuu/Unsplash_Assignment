package com.androdev.unsplashapp.network.dataAgents

import com.androdev.unsplashapp.data.vos.PhotoVO
import io.reactivex.Observable

interface photoDataAgent {

    fun getPhotosList(apiKey : String,
                      onSuccess : (List<PhotoVO>) ->Unit,
                      onFailure : (String)-> Unit)

    fun searchPhoto(
                    apiKey : String,
                    query : String,
                    onSuccess : (List<PhotoVO>) -> Unit ,
                    onFailure: (String) -> Unit)

    fun getPhotosListObservable(
        apiKey : String
    ): Observable<List<PhotoVO>>

}