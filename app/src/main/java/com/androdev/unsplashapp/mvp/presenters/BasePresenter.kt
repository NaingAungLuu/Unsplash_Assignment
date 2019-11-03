package com.androdev.unsplashapp.mvp.presenters

import androidx.lifecycle.ViewModel
import com.androdev.unsplashapp.mvp.views.BaseView

abstract class BasePresenter<T : BaseView> : ViewModel(){

    protected lateinit var mView : T
    fun initPresenter(view : T)
    {
        this.mView = view
    }

}