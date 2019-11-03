package com.androdev.unsplashapp.mvp.presenters

import androidx.lifecycle.Observer
import com.androdev.unsplashapp.activities.BaseActivity
import com.androdev.unsplashapp.activities.DetailActivity
import com.androdev.unsplashapp.data.model.PhotoDataModelImpl
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.mvp.views.PhotoListView

class PhotosListPresenter : BasePresenter<PhotoListView>() {

    private val model =PhotoDataModelImpl
    private lateinit var data : List<PhotoVO>

    fun onUIReady(activity: BaseActivity)
    {
        model.getPhotoList {

        }.observe(activity , Observer {
            mView.showPhotos(it)
        })

    }

    fun onTapPhoto(id : String)
    {
        mView.navigateToDetail(id)
    }

}