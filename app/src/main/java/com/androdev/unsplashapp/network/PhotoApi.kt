package com.androdev.unsplashapp.network

import com.androdev.unsplashapp.data.vos.PhotoArrayVO
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.network.responses.PhotoResponse
import com.androdev.unsplashapp.network.responses.SearchResponse
import com.androdev.unsplashapp.utils.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    @GET(GET_PHOTOS)
    fun getPhotosList(@Query(PARAM_APIKEY) apiKey : String , @Query(PARAM_PAGE_ON) pageNo : Int ) : Call<List<PhotoVO>>

    @GET(SEARCH_PHOTOS)
    fun searchPhoto(@Query(PARAM_APIKEY) apiKey : String , @Query(PARAM_QUERY) query : String):Call<SearchResponse>

    @GET(GET_PHOTOS)
    fun getPhotosListObservabe(@Query(PARAM_APIKEY) apiKey : String , @Query(PARAM_PAGE_ON) pageNo : Int ) : Observable<List<PhotoVO>>

}