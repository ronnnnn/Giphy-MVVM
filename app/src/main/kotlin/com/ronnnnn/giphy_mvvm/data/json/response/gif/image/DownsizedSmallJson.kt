package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a version of this GIF downsized to be under 200kb.
 */
data class DownsizedSmallJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String
)

fun DownsizedSmallJson.toEntity(): DownsizedSmall =
        DownsizedSmall(url, width.toInt(), height.toInt(), size.toInt())