package com.ronnnnn.giphy_mvvm.data.json.response.user

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2017/10/13.
 */
data class User(
        @Json(name = "avatar_url")
        val avatarUrl: String,
        @Json(name = "banner_url")
        val bannerUrl: String,
        @Json(name = "profile_url")
        val profileUrl: String,
        val username: String,
        @Json(name = "display_name")
        val displayName: String,
        val twitter: String
)
