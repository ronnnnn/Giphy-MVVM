package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding versions of this GIF with a fixed width of 100 pixels. Good for mobile keyboards.
 */
data class FixedWidthSmall(
        val url: String,
        val width: Int,
        val height: Int,
        val size: Int,
        val mp4: String,
        val mp4Size: Int,
        val webp: String,
        val webpSize: Int
)