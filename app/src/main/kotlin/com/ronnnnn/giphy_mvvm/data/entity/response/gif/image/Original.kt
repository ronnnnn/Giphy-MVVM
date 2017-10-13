package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Data surrounding the original version of this GIF. Good for desktop use.
 */
data class Original(
        val url: String,
        val width: Int,
        val height: Int,
        val size: Int,
        val frames: Int,
        val mp4: String,
        @Json(name = "mp4_size")
        val mp4Size: Int,
        val webp: String,
        @Json(name = "webp_size")
        val webpSize: Int
)