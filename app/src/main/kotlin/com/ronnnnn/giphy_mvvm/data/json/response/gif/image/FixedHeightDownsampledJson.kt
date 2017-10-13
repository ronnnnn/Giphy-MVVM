package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Data surrounding versions of this GIF with a fixed height of 200 pixels and the number of frames reduced to 6.
 */
data class FixedHeightDownsampledJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String,
        val webp: String,
        @Json(name = "webp_size")
        val webpSize: String
)

fun FixedHeightDownsampledJson.toEntity(): FixedHeightDownsampled =
        FixedHeightDownsampled(url, width.toInt(), height.toInt(), size.toInt(), webp, webpSize.toInt())