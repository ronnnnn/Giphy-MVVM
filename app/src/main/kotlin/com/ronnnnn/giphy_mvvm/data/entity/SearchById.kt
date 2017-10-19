package com.ronnnnn.giphy_mvvm.data.entity

import com.ronnnnn.giphy_mvvm.data.json.response.Meta
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif

/**
 * Created by kokushiseiya on 2017/10/19.
 */
data class SearchById(
        val gif: Gif,
        val meta: Meta
)