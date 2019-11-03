package com.androdev.unsplashapp.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androdev.unsplashapp.data.vos.PhotoVO
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
abstract class PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPhotos(photoList : List<PhotoVO>) : Single<LongArray>

    @Query("SELECT * FROM photos")
    abstract fun getPhotos():LiveData<List<PhotoVO>>

    @Query("SELECT * FROM photos")
    abstract fun getPhotosMaybe(): Maybe<List<PhotoVO>>

    @Query("SELECT * FROM photos WHERE id = :photoID")
    abstract fun getPhotoByID(photoID : String):LiveData<PhotoVO>

}