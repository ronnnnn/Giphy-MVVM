package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a static preview image of the downsized version of this GIF.
 */
data class DownsizedStillJson(
        val url: String,
        val width: String,
        val height: String
)

fun DownsizedStillJson.toEntity(): DownsizedStill =
        DownsizedStill(url, width.toInt(), height.toInt())