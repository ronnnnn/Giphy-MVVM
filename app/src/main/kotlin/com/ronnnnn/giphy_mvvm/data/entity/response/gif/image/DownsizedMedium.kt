package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a version of this GIF downsized to be under 5mb.
 */
data class DownsizedMedium(
        val url: String,
        val width: Int,
        val height: Int,
        val size: Int
)