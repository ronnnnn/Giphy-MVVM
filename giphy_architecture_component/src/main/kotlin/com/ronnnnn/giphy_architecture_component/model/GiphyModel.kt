package com.ronnnnn.giphy_architecture_component.model

import android.content.Context
import android.support.annotation.CheckResult
import com.ronnnnn.giphy_architecture_component.R
import com.ronnnnn.giphy_architecture_component.data.remote.GiphyApi
import com.ronnnnn.giphy_mvvm.data.entity.SearchById
import com.ronnnnn.giphy_mvvm.data.json.Trending
import com.ronnnnn.giphy_mvvm.data.json.toEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/10/13.
 */
@Singleton
class GiphyModel @Inject constructor(private val context: Context, private val giphyApi: GiphyApi) {

    @CheckResult
    fun getTrending(offset: Int, limit: Int, rating: String, format: String): Single<Trending> =
            giphyApi.getTrending(context.getString(R.string.giphy_api_key), limit, offset, rating, format)
                    .map { trendingJson -> trendingJson.toEntity() }
                    .subscribeOn(Schedulers.io())

    @CheckResult
    fun getGifById(gifId: String): Single<SearchById> =
            giphyApi.getGifById(context.getString(R.string.giphy_api_key), gifId)
                    .map { searchById -> searchById.toEntity() }
                    .subscribeOn(Schedulers.io())
}