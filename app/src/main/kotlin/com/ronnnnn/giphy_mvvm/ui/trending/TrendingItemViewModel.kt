package com.ronnnnn.giphy_mvvm.ui.trending

import android.databinding.ObservableField
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif

/**
 * Created by kokushiseiya on 2017/10/17.
 */
class TrendingItemViewModel(private val view: TrendingItemContract) {

    val gifId: ObservableField<String> = ObservableField()
    val imageUrl: ObservableField<String> = ObservableField()

    fun loadItem(gif: Gif) {
        gifId.set(gif.id)
        imageUrl.set(gif.images.fixedHeight.url)
    }

    fun startDetail(gifId: String) {
        view.onItemClicked(gifId)
    }
}