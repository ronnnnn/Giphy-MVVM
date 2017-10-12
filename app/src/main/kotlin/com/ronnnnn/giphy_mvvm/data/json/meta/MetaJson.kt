package com.ronnnnn.giphy_mvvm.data.json.meta

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class MetaJson(
        val msg: String,
        val status: Int,
        @Json(name = "response_id")
        val responseId: String
)