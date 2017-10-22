package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class Image(
        val fixedHeight: FixedHeight,
        val fixedHeightStill: FixedHeightStill,
        val fixedHeightDownsampled: FixedHeightDownsampled,
        val fixedWidth: FixedWidth,
        val fixedWidthStill: FixedWidthStill,
        val fixedWidthDownsampled: FixedWidthDownsampled,
        val fixedHeightSmall: FixedHeightSmall,
        val fixedHeightSmallStill: FixedHeightSmallStill,
        val fixedWidthSmall: FixedWidthSmall,
        val fixedWidthSmallStill: FixedWidthSmallStill,
        val downsized: Downsized,
        val downsizedStill: DownsizedStill,
        val downsizedLarge: DownsizedLarge,
        val downsizedMedium: DownsizedMedium,
        val downsizedSmall: DownsizedSmall,
        val original: Original,
        val originalStill: OriginalStill,
        val looping: Looping,
        val preview: Preview,
        val previewGif: PreviewGif
)