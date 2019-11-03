package com.androdev.unsplashapp.data.model

import android.content.Context
import com.androdev.unsplashapp.network.dataAgents.RetrofitDataAgent
import com.androdev.unsplashapp.persistance.PhotoDatabase

abstract class BaseModel {
    protected val dataAgent = RetrofitDataAgent
    protected lateinit var database : PhotoDatabase

    fun initDatabase(context : Context)
    {
        database = PhotoDatabase.getInstance(context)
    }

}