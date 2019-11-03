package com.androdev.unsplashapp.network.dataAgents

import com.androdev.unsplashapp.data.vos.PhotoArrayVO
import com.androdev.unsplashapp.network.PhotoApi
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.network.responses.PhotoResponse
import com.androdev.unsplashapp.network.responses.SearchResponse
import com.androdev.unsplashapp.utils.API_KEY
import com.androdev.unsplashapp.utils.BASE_URL
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgent : photoDataAgent {



    private lateinit var photoApi : PhotoApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15 , TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15 , TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        photoApi = retrofit.create(PhotoApi::class.java)


    }

    override fun searchPhoto(
        apiKey : String,
        query: String,
        onSuccess: (List<PhotoVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = photoApi.searchPhoto(apiKey , query)
        call.enqueue(object : Callback<SearchResponse>{

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                onFailure(t.localizedMessage.toString())
            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                val searchResponse = response.body()
                if(searchResponse != null)
                {
                    onSuccess(searchResponse.result)
                }
                else
                {
                    onFailure("Network error occurred")
                }
            }

        })

    }

    override fun getPhotosList(
        apiKey: String,
        onSuccess: (List<PhotoVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = photoApi.getPhotosList(apiKey , 2)
        call.enqueue(object : Callback<List<PhotoVO>>{


            override fun onFailure(call: Call<List<PhotoVO>>, t: Throwable) {

                onFailure(t.localizedMessage!!)
                println(t.localizedMessage.toString())

            }


            override fun onResponse(call: Call<List<PhotoVO>>, response: Response<List<PhotoVO>>) {

                val photoResponse = response.body()
                if(photoResponse != null)
                {
                    onSuccess(photoResponse)
                }
                else
                {
                    onFailure("Network Connection Failed")
                }

            }

        })


    }

    override fun getPhotosListObservable(
        apiKey : String
    ):Observable<List<PhotoVO>>{

        return photoApi.getPhotosListObservabe(API_KEY , 1)
            .flatMap<List<PhotoVO>>{
                Observable.just(it)
            }

    }

}