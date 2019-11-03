package com.androdev.unsplashapp.view.holders

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.TouchDelegate
import android.view.View
import coil.Coil
import coil.ImageLoader
import coil.api.get
import coil.api.load
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.delegates.PhotoItemDelegate
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.view_item_photo.view.*

class PhotoViewHolder(itemView: View , private val delegate: PhotoItemDelegate) : BaseViewHolder<PhotoVO>(itemView) {

    init {
        itemView.cvContainer.setOnClickListener {
            delegate.onTapPhoto(data!!.id)

        }
    }

    override fun bindData(data: PhotoVO) {

        Glide.with(itemView.context)
            .asBitmap()
            .load(data.urls!!.regular)
            .into(object : CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {

                    val ratio : Float = resource.height/resource.width.toFloat()
                    println("Image ratio = $ratio and holder width = ${itemView.ivImageView.width}")
                    itemView.ivImageView.setImageBitmap(resource)
                    itemView.layoutParams.height = (itemView.width*ratio).toInt()

                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
                }
            })


    }
}