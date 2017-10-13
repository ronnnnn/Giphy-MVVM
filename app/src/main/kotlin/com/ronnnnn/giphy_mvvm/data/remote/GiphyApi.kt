package com.ronnnnn.giphy_mvvm.data.remote

import android.support.annotation.CheckResult
import com.ronnnnn.giphy_mvvm.data.json.TrendingJson
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2017/10/13.
 */
interface GiphyApi {

    @CheckResult
    fun getTrending(
            apiKey: String,
            limit: Int = 25,
            offset: Int = 0,
            rating: String = "",
            format: String = "json"
    ): Single<TrendingJson>
}