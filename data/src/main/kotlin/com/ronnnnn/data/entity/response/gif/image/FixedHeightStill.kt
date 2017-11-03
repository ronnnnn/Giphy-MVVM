package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a static image of this GIF with a fixed height of 200 pixels.
 */
data class FixedHeightStill(
        val url: String,
        val width: Int,
        val height: Int
)