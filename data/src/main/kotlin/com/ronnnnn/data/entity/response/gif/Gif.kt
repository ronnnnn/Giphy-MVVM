package com.ronnnnn.giphy_mvvm.data.json.response.gif

import com.ronnnnn.giphy_mvvm.data.json.response.gif.image.Image
import com.ronnnnn.giphy_mvvm.data.json.response.user.User
import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class Gif(
        val type: String,
        val id: String,
        val slug: String,
        val url: String,
        val bitlyUrl: String,
        val embedUrl: String,
        val username: String,
        val source: String,
        val rating: String,
        val user: User?,
        val sourceTld: String,
        val sourcePostUrl: String,
        val updateDatetime: String?,
        val createDatetime: String?,
        val importDatetime: String,
        val trendingDateTime: String?,
        val images: Image
)