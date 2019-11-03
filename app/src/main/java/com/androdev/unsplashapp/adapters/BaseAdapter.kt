package com.androdev.unsplashapp.adapters

import androidx.recyclerview.widget.RecyclerView
import com.androdev.unsplashapp.view.holders.BaseViewHolder

abstract class BaseAdapter<T , VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>(){

    protected var data : MutableList<T> = ArrayList()

    fun setNewData(photos : MutableList<T>)
    {
        this.data = photos
        notifyDataSetChanged()
    }


}