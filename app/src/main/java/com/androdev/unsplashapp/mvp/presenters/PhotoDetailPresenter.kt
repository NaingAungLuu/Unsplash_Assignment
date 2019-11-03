package com.androdev.unsplashapp.mvp.presenters

import androidx.lifecycle.Observer
import com.androdev.unsplashapp.activities.BaseActivity
import com.androdev.unsplashapp.data.model.PhotoDataModelImpl
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.mvp.views.PhotoDetailView

class PhotoDetailPresenter : BasePresenter<PhotoDetailView>() {
    private val model = PhotoDataModelImpl
    fun onUiReady(activity : BaseActivity  , photoID : String)
    {
      model.getPhotoByID(photoID)
          .observe(activity , Observer {
         mView.showPhotoDetails(it)
      })
    }
}