package com.ronnnnn.giphy_mvvm.data.json

import com.ronnnnn.giphy_mvvm.data.entity.SearchById
import com.ronnnnn.giphy_mvvm.data.json.response.MetaJson
import com.ronnnnn.giphy_mvvm.data.json.response.gif.GifJson
import com.ronnnnn.giphy_mvvm.data.json.response.gif.toEntity
import com.ronnnnn.giphy_mvvm.data.json.response.toEntity
import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/19.
 */
data class SearchByIdJson(
        @Json(name = "data")
        val gifJson: GifJson,
        @Json(name = "meta")
        val metaJson: MetaJson
)

fun SearchByIdJson.toEntity(): SearchById =
        SearchById(gifJson.toEntity(), metaJson.toEntity())