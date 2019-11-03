package com.androdev.unsplashapp.mvp.views

import com.androdev.unsplashapp.data.vos.PhotoVO

interface PhotoListView : BaseView {

    fun showPhotos(photos : List<PhotoVO>)
    fun showError(msg : String)
    fun navigateToDetail(url : String)
}