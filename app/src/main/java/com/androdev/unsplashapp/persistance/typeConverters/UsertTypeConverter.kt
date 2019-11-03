package com.androdev.unsplashapp.persistance.typeConverters

import androidx.room.TypeConverter
import com.androdev.unsplashapp.data.vos.UrlsVO
import com.androdev.unsplashapp.data.vos.UserVO
import com.google.gson.Gson

class UsertTypeConverter {

    @TypeConverter
    fun toJson(user : UserVO):String
    {
        return Gson().toJson(user)
    }

    @TypeConverter
    fun fromJson(json : String): UserVO
    {
        return Gson().fromJson(json , UserVO::class.java)
    }

}