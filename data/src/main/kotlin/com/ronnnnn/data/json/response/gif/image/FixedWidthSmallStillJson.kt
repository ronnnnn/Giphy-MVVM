package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a static image of this GIF with a fixed width of 100 pixels.
 */
data class FixedWidthSmallStillJson(
        val url: String,
        val width: String,
        val height: String
)

fun FixedWidthSmallStillJson.toEntity(): FixedWidthSmallStill =
        FixedWidthSmallStill(url, width.toInt(), height.toInt())