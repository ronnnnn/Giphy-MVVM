package com.ronnnnn.giphy_mvvm.data.json.response.gif.image

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class ImageJson(
        @Json(name = "fixed_height")
        val fixedHeightJson: FixedHeightJson,
        @Json(name = "fixed_height_still")
        val fixedHeightStillJson: FixedHeightStillJson,
        @Json(name = "fixed_height_downsampled")
        val fixedHeightDownsampledJson: FixedHeightDownsampledJson,
        @Json(name = "fixed_width")
        val fixedWidthJson: FixedWidthJson,
        @Json(name = "fixed_width_still")
        val fixedWidthStillJson: FixedWidthStillJson,
        @Json(name = "fixed_width_downsampled")
        val fixedWidthDownsampledJson: FixedWidthDownsampledJson,
        @Json(name = "fixed_height_small")
        val fixedHeightSmallJson: FixedHeightSmallJson,
        @Json(name = "fixed_height_small_still")
        val fixedHeightSmallStillJson: FixedHeightSmallStillJson,
        @Json(name = "fixed_width_small")
        val fixedWidthSmallJson: FixedWidthSmallJson,
        @Json(name = "fixed_width_small_still")
        val fixedWidthSmallStillJson: FixedWidthSmallStillJson,
        @Json(name = "downsized")
        val downsizedJson: DownsizedJson,
        @Json(name = "downsized_still")
        val downsizedStillJson: DownsizedStillJson,
        @Json(name = "downsized_large")
        val downsizedLargeJson: DownsizedLargeJson,
        @Json(name = "downsized_medium")
        val downsizedMediumJson: DownsizedMediumJson,
        @Json(name = "downsized_small")
        val downsizedSmallJson: DownsizedSmallJson,
        @Json(name = "original")
        val originalJson: OriginalJson,
        @Json(name = "original_still")
        val originalStillJson: OriginalStillJson,
        @Json(name = "looping")
        val loopingJson: LoopingJson,
        @Json(name = "preview")
        val previewJson: PreviewJson,
        @Json(name = "preview_gif")
        val previewGifJson: PreviewGifJson
)

fun ImageJson.toEntity(): Image =
        Image(
                fixedHeightJson.toEntity(),
                fixedHeightStillJson.toEntity(),
                fixedHeightDownsampledJson.toEntity(),
                fixedWidthJson.toEntity(),
                fixedWidthStillJson.toEntity(),
                fixedWidthDownsampledJson.toEntity(),
                fixedHeightSmallJson.toEntity(),
                fixedHeightSmallStillJson.toEntity(),
                fixedWidthSmallJson.toEntity(),
                fixedWidthSmallStillJson.toEntity(),
                downsizedJson.toEntity(),
                downsizedStillJson.toEntity(),
                downsizedLargeJson.toEntity(),
                downsizedMediumJson.toEntity(),
                downsizedSmallJson.toEntity(),
                originalJson.toEntity(),
                originalStillJson.toEntity(),
                loopingJson.toEntity(),
                previewJson.toEntity(),
                previewGifJson.toEntity()
        )