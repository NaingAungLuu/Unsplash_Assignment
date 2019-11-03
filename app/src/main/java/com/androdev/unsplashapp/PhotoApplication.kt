package com.androdev.unsplashapp

import android.app.Application
import android.widget.Toast
import com.androdev.unsplashapp.data.model.PhotoDataModelImpl
import com.androdev.unsplashapp.network.dataAgents.RetrofitDataAgent
import com.androdev.unsplashapp.persistance.PhotoDatabase
import com.androdev.unsplashapp.utils.API_KEY

class PhotoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PhotoDataModelImpl.initDatabase(applicationContext)

    }


}