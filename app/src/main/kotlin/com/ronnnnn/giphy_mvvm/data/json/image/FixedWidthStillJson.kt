package com.ronnnnn.giphy_mvvm.data.json.image

/**
 * Data surrounding a static image of this GIF with a fixed width of 200 pixels.
 */
data class FixedWidthStillJson(
        val url: String,
        val width: String,
        val height: String
)