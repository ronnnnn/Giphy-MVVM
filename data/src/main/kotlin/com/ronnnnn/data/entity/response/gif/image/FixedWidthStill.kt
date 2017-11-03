package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a static image of this GIF with a fixed width of 200 pixels.
 */
data class FixedWidthStill(
        val url: String,
        val width: Int,
        val height: Int
)