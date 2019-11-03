package com.androdev.unsplashapp.persistance.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoriesListTypeConverter {

    @TypeConverter
    fun toJson(categories : List<String>):String{
        return Gson().toJson(categories)
    }


    @TypeConverter
    fun fromJson(json : String): List<String>
    {
        val token = object : TypeToken<List<String>>(){}.type

        return Gson().fromJson(json , token)
    }

}