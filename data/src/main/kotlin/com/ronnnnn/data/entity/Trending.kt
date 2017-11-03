package com.ronnnnn.giphy_mvvm.data.json

import com.ronnnnn.giphy_mvvm.data.json.response.Meta
import com.ronnnnn.giphy_mvvm.data.json.response.Pagination
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class Trending(
        val gifs: List<Gif>,
        val pagination: Pagination,
        val meta: Meta
)