package com.ronnnnn.giphy_mvvm.data.json.trending

import com.ronnnnn.giphy_mvvm.data.json.gif.GifJson
import com.ronnnnn.giphy_mvvm.data.json.meta.MetaJson
import com.ronnnnn.giphy_mvvm.data.json.pagination.PaginationJson
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