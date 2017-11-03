package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a static image of this GIF with a fixed width of 200 pixels.
 */
data class FixedWidthStillJson(
        val url: String,
        val width: String,
        val height: String
)

fun FixedWidthStillJson.toEntity(): FixedWidthStill =
        FixedWidthStill(url, width.toInt(), height.toInt())