package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a static image of this GIF with a fixed height of 100 pixels.
 */
data class FixedHeightSmallStillJson(
        val url: String,
        val width: String,
        val height: String
)

fun FixedHeightSmallStillJson.toEntity(): FixedHeightSmallStill
        = FixedHeightSmallStill(url, width.toInt(), height.toInt())