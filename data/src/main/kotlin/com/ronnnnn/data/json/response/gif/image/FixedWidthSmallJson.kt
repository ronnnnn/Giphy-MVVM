package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Data surrounding versions of this GIF with a fixed width of 100 pixels. Good for mobile keyboards.
 */
data class FixedWidthSmallJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String,
        val mp4: String,
        @Json(name = "mp4_size")
        val mp4Size: String,
        val webp: String,
        @Json(name = "webp_size")
        val webpSize: String
)

fun FixedWidthSmallJson.toEntity(): FixedWidthSmall =
        FixedWidthSmall(url, width.toInt(), height.toInt(), size.toInt(), mp4, mp4Size.toInt(), webp, webpSize.toInt())