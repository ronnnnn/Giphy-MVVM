package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Data surrounding a version of this GIF in .MP4 format limited to 50kb that displays the first 1-2 seconds of the GIF.
 */
data class Preview(
        val mp4: String,
        @Json(name = "mp4_size")
        val mp4Size: Int,
        val width: Int,
        val height: Int
)