package com.androdev.unsplashapp.persistance.typeConverters

import androidx.room.TypeConverter
import com.androdev.unsplashapp.data.vos.SponsorshipVO
import com.google.gson.Gson

class SponsorshipTypeConverter {

    @TypeConverter
    fun toJson(sponsorship : SponsorshipVO?):String
    {
        return Gson().toJson(sponsorship)
    }

    @TypeConverter
    fun fromJson(json : String):SponsorshipVO?
    {
        return Gson().fromJson(json , SponsorshipVO::class.java)
    }

}