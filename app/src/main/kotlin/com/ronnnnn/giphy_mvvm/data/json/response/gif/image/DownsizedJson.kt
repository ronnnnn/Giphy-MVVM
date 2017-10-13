package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a version of this GIF downsized to be under 2mb.
 */
data class DownsizedJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String
)

fun DownsizedJson.toEntity(): Downsized =
        Downsized(url, width.toInt(), height.toInt(), size.toInt())