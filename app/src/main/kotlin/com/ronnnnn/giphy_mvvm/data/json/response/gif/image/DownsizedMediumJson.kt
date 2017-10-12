package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a version of this GIF downsized to be under 5mb.
 */
data class DownsizedMediumJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String
)