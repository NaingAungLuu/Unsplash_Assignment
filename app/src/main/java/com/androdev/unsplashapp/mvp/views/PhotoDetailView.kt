package com.androdev.unsplashapp.mvp.views

import com.androdev.unsplashapp.data.vos.PhotoVO

interface PhotoDetailView : BaseView {
    fun showPhotoDetails(data : PhotoVO)
}