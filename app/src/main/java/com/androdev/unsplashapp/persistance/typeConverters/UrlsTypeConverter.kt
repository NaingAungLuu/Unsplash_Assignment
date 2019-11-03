package com.androdev.unsplashapp.persistance.typeConverters

import androidx.room.TypeConverter
import com.androdev.unsplashapp.data.vos.UrlsVO
import com.google.gson.Gson

class UrlsTypeConverter {

    @TypeConverter
    fun toJson(urls : UrlsVO):String
    {
        return Gson().toJson(urls)
    }

    @TypeConverter
    fun fromJson(json : String): UrlsVO
    {
        return Gson().fromJson(json , UrlsVO::class.java)
    }

}