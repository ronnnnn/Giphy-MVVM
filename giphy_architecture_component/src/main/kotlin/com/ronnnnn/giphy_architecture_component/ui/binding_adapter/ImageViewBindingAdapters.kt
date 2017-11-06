package com.ronnnnn.giphy_architecture_conponent.ui.binding_adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.ronnnnn.giphy_architecture_component.di.GlideApp

/**
 * Created by kokushiseiya on 2017/10/17.
 */

@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String?) {
    imageUrl ?: return

    GlideApp.with(context)
            .load(imageUrl)
            .into(this)
}