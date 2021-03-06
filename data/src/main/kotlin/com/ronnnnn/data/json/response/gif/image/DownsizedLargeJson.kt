package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a version of this GIF downsized to be under 8mb.
 */
data class DownsizedLargeJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String
)

fun DownsizedLargeJson.toEntity(): DownsizedLarge =
        DownsizedLarge(url, width.toInt(), height.toInt(), size.toInt())