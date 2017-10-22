package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding versions of this GIF with a fixed width of 200 pixels and the number of frames reduced to 6.
 */
data class FixedWidthDownsampled(
        val url: String,
        val width: Int,
        val height: Int,
        val size: Int,
        val webp: String,
        val webpSize: Int
)