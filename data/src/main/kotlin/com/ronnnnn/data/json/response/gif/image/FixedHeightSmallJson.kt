package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Data surrounding versions of this GIF with a fixed height of 100 pixels. Good for mobile keyboards.
 */
data class FixedHeightSmallJson(
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

fun FixedHeightSmallJson.toEntity(): FixedHeightSmall =
        FixedHeightSmall(url, width.toInt(), height.toInt(), size.toInt(), mp4, mp4Size.toInt(), webp, webpSize.toInt())