package com.ronnnnn.giphy_mvvm.data.json

import com.ronnnnn.giphy_mvvm.data.json.response.MetaJson
import com.ronnnnn.giphy_mvvm.data.json.response.PaginationJson
import com.ronnnnn.giphy_mvvm.data.json.response.gif.GifJson
import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class TrendingJson(
        @Json(name = "data")
        val gifJsons: List<GifJson>,
        @Json(name = "pagination")
        val paginationJson: PaginationJson,
        @Json(name = "meta")
        val metaJson: MetaJson
)