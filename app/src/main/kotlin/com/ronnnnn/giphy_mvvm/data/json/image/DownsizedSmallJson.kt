package com.ronnnnn.giphy_mvvm.data.json.image

/**
 * Data surrounding a version of this GIF downsized to be under 200kb.
 */
data class DownsizedSmallJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String
)