package com.androdev.unsplashapp.persistance.typeConverters

import androidx.room.TypeConverter
import com.androdev.unsplashapp.data.vos.ProfileImageVO
import com.google.gson.Gson

class ProfileImageTypeConverter {

    @TypeConverter
    fun toJson(profile : ProfileImageVO):String
    {
        return Gson().toJson(profile)
    }

    @TypeConverter
    fun fromJson(json : String):ProfileImageVO
    {
        return Gson().fromJson(json , ProfileImageVO::class.java)
    }

}