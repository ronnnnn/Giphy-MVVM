package com.ronnnnn.giphy_mvvm.data.json.image

import com.squareup.moshi.Json

/**
 * Data surrounding the original version of this GIF. Good for desktop use.
 */
data class OriginalJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String,
        val frames: String,
        val mp4: String,
        @Json(name = "mp4_size")
        val mp4Size: String,
        val webp: String,
        @Json(name = "webp_size")
        val webpSize: String
)