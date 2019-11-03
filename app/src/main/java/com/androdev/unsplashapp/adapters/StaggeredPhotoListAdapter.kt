package com.androdev.unsplashapp.adapters

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.api.get
import com.androdev.unsplashapp.R
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.delegates.PhotoItemDelegate
import com.androdev.unsplashapp.view.holders.PhotoViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.view_item_photo.view.*

class StaggeredPhotoListAdapter(private val delegate : PhotoItemDelegate) : BaseAdapter<PhotoVO , PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_photo , parent , false)

        return PhotoViewHolder(view , delegate)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.data = data[position]

    }


}