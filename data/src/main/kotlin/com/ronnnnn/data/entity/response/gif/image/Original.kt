package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding the original version of this GIF. Good for desktop use.
 */
data class Original(
        val url: String,
        val width: Int,
        val height: Int,
        val size: Int,
        val frames: Int,
        val mp4: String,
        val mp4Size: Int,
        val webp: String,
        val webpSize: Int
)