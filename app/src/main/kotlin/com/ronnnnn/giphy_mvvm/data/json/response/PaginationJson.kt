package com.ronnnnn.giphy_mvvm.data.json.response

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class PaginationJson(
        val offset: Int,
        @Json(name = "total_count")
        val totalCount: Int,
        val count: Int
)