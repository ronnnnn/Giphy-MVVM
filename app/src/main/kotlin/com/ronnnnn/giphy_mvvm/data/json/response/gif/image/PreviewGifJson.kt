package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a version of this GIF limited to 50kb that displays the first 1-2 seconds of the GIF.
 */
data class PreviewGifJson(
        val url: String,
        val width: String,
        val height: String,
        val size: String
)