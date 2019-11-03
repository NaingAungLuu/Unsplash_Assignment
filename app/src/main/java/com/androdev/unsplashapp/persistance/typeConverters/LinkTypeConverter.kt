package com.androdev.unsplashapp.persistance.typeConverters

import androidx.room.TypeConverter
import com.androdev.unsplashapp.data.vos.LinksVO
import com.google.gson.Gson

class LinkTypeConverter {

    @TypeConverter
    fun toJson(links : LinksVO):String
    {
        return Gson().toJson(links)
    }

    @TypeConverter
    fun fromJson(json : String):LinksVO
    {
        return Gson().fromJson(json ,LinksVO::class.java)
    }

}