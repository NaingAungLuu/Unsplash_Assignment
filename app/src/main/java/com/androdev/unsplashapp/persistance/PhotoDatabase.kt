package com.androdev.unsplashapp.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.persistance.daos.PhotoDao
import com.androdev.unsplashapp.persistance.typeConverters.*

@Database(entities = [PhotoVO::class] , version = 5 , exportSchema = false)
@TypeConverters(value = [LinkTypeConverter::class , ProfileImageTypeConverter::class , SponsorTypeConverter::class
                        , SponsorshipTypeConverter::class , UrlsTypeConverter::class , UsertTypeConverter::class
                        , CategoriesListTypeConverter::class])
abstract class PhotoDatabase : RoomDatabase(){

    abstract fun getPhotoDao():PhotoDao

    companion object{
        private var instance : PhotoDatabase? = null

        fun getInstance(context : Context):PhotoDatabase
        {
            if (instance == null)
            {
                instance = Room.databaseBuilder(context , PhotoDatabase::class.java , "photo_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val db = instance!!
            return db
        }
    }

}