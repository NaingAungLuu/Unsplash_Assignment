package com.androdev.unsplashapp.network.responses

import com.androdev.unsplashapp.data.vos.PhotoVO
import com.google.gson.annotations.SerializedName

data class SearchResponse(

    @SerializedName(value ="total")
    val total : Int,

    @SerializedName(value = "total_pages")
    val total_pages : Int,

    @SerializedName(value = "results")
    val result : List<PhotoVO>


) {
}