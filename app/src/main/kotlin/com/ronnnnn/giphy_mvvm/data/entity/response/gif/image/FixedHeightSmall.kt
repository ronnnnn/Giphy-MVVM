package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Data surrounding versions of this GIF with a fixed height of 100 pixels. Good for mobile keyboards.
 */
data class FixedHeightSmall(
        val url: String,
        val width: Int,
        val height: Int,
        val size: Int,
        val mp4: String,
        @Json(name = "mp4_size")
        val mp4Size: Int,
        val webp: String,
        @Json(name = "webp_size")
        val webpSize: Int
)