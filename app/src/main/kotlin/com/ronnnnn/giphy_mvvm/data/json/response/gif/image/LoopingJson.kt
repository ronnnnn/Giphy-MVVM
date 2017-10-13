package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Data surrounding a version of this GIF set to loop for 15 seconds.
 */
data class LoopingJson(
        val mp4: String
)

fun LoopingJson.toEntity(): Looping =
        Looping(mp4)