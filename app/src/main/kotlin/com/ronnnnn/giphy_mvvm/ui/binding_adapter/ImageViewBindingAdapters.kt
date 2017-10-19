package com.ronnnnn.giphy_mvvm.ui.binding_adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.ronnnnn.giphy_mvvm.di.GlideApp

/**
 * Created by kokushiseiya on 2017/10/17.
 */

@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String) {
    GlideApp.with(context)
            .load(imageUrl)
            .into(this)
}