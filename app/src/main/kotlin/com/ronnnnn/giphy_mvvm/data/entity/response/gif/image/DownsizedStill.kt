package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a static preview image of the downsized version of this GIF.
 */
data class DownsizedStill(
        val url: String,
        val width: Int,
        val height: Int
)