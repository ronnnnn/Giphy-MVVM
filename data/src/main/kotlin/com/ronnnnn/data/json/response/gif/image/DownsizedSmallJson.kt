package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Data surrounding a version of this GIF downsized to be under 200kb.
 */
data class DownsizedSmallJson(
        val width: String,
        val height: String,
        val mp4: String,
        @Json(name = "mp4_size")
        val mp4Size: String
)

fun DownsizedSmallJson.toEntity(): DownsizedSmall =
        DownsizedSmall(width.toInt(), height.toInt(), mp4, mp4Size.toInt())