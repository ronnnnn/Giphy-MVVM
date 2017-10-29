package com.ronnnnn.giphy_mvvm.ui.trending

import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif

/**
 * Created by kokushiseiya on 2017/10/17.
 */
interface TrendingContract {

    fun showImages(images: List<Gif>)

    fun addImages(images: List<Gif>)
}