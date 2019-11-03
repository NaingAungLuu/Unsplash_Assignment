package com.androdev.unsplashapp.network.responses


import com.androdev.unsplashapp.data.vos.PhotoArrayVO
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("")
    val photoArray: PhotoArrayVO

) {
}