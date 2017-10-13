package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Data surrounding versions of this GIF with a fixed height of 200 pixels and the number of frames reduced to 6.
 */
data class FixedHeightDownsampled(
        val url: String,
        val width: Int,
        val height: Int,
        val size: Int,
        val webp: String,
        @Json(name = "webp_size")
        val webpSize: Int
)