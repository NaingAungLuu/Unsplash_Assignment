package com.androdev.unsplashapp.persistance.typeConverters

import androidx.room.TypeConverter
import com.androdev.unsplashapp.data.vos.SponsorVO
import com.google.gson.Gson

class SponsorTypeConverter {

    @TypeConverter
    fun toJson(sponsor : SponsorVO):String
    {
        return Gson().toJson(sponsor)
    }

    @TypeConverter
    fun fromJson(json : String):SponsorVO
    {
        return Gson().fromJson(json , SponsorVO::class.java)
    }

}