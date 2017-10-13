package com.ronnnnn.giphy_mvvm.data.json.response

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class Meta(
        val msg: String,
        val status: Int,
        @Json(name = "response_id")
        val responseId: String
)