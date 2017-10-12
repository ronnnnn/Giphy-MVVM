package com.ronnnnn.giphy_mvvm.data.json.response.gif

import com.ronnnnn.giphy_mvvm.data.json.response.gif.image.ImageJson
import com.ronnnnn.giphy_mvvm.data.json.response.user.UserJson
import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class GifJson(
        val type: String,
        val id: String,
        val slug: String,
        val url: String,
        @Json(name = "bitly_url")
        val bitlyUrl: String,
        @Json(name = "embed_url")
        val embedUrl: String,
        val username: String,
        val source: String,
        val rating: String,
        @Json(name = "user")
        val userJson: UserJson?,
        @Json(name = "source_tld")
        val sourceTld: String,
        @Json(name = "source_post_url")
        val sourcePostUrl: String,
        @Json(name = "update_datetime")
        val updateDatetime: String,
        @Json(name = "create_datetime")
        val createDatetime: String,
        @Json(name = "import_datetime")
        val importDatetime: String,
        @Json(name = "trending_datetime")
        val trendingDateTime: String,
        @Json(name = "images")
        val imageJsons: List<ImageJson>
        )