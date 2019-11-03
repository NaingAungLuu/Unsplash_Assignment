package com.androdev.unsplashapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.androdev.unsplashapp.R
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.mvp.presenters.PhotoDetailPresenter
import com.androdev.unsplashapp.mvp.presenters.PhotosListPresenter
import com.androdev.unsplashapp.mvp.views.PhotoDetailView
import com.androdev.unsplashapp.utils.PHOTO_ID
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.bottomsheet_detail.*
import kotlinx.android.synthetic.main.view_item_photo.*
import kotlin.math.round

class DetailActivity : BaseActivity() , PhotoDetailView{


    override fun showPhotoDetails(data: PhotoVO) {
        ivImageDetail.load(data.urls!!.regular)
        {
            crossfade(true)
        }
        Glide.with(applicationContext).load(data.user!!.profile_image.medium).into(ivDetailProfile)
        tvDetailFullName.text = data.user!!.name
        tvDetailUserName.text = data.user!!.username
    }

    private lateinit var mPresenter : PhotoDetailPresenter

    companion object
    {
    fun newIntent(context : Context, photoUrl : String):Intent{
        val intent = Intent(context ,DetailActivity::class.java)
        intent.putExtra(PHOTO_ID , photoUrl)
        return intent
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        println(intent.getStringExtra(PHOTO_ID))
        mPresenter = PhotoDetailPresenter()
        mPresenter.initPresenter(this)
        mPresenter.onUiReady(this , intent.getStringExtra(PHOTO_ID)!!)

    }
}