package com.androdev.unsplashapp.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.utils.API_KEY
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PhotoDataModelImpl : BaseModel() ,PhotoDataModel {

    override fun getPhotoByID(photoID: String): LiveData<PhotoVO> {
        return Transformations.distinctUntilChanged(
            database.getPhotoDao().getPhotoByID(photoID)
        )
    }

    override fun getPhotoList(onFailure : (String) -> Unit):LiveData<List<PhotoVO>> {

//        if (database.getPhotoDao().getPhotos().value == null) {
//                dataAgent.getPhotosList(API_KEY , {
//
//                    database.getPhotoDao().insertPhotos(it)
//
//                },{
//                    onFailure(it)
//                })
//        }

        val databasSingle = database.getPhotoDao().getPhotosMaybe().subscribeOn(Schedulers.io())
            .flatMap {
                if(it.isEmpty())
                {
                    Maybe.empty()
                }
                else
                {
                    Maybe.just(it)
                }
            }

        val networkObservable = dataAgent.getPhotosListObservable(API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                onFailure(it.localizedMessage)
            }

        Observable.concat(databasSingle.toObservable() , networkObservable )
            .firstElement()
            .flatMap<LongArray>{
                database.getPhotoDao().insertPhotos(it).subscribeOn(Schedulers.io()).toMaybe()
            }
            .subscribe(
                {

                },{
                    onFailure(it.message ?: "An error occurred")
                })


        return Transformations.distinctUntilChanged(
            database.getPhotoDao().getPhotos()
        )

    }



}