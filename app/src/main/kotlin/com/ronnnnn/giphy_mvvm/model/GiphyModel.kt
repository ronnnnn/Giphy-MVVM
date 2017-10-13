package com.ronnnnn.giphy_mvvm.model

import android.support.annotation.CheckResult
import com.ronnnnn.giphy_mvvm.data.remote.GiphyApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/10/13.
 */
@Singleton
class GiphyModel @Inject constructor(private val giphyApi: GiphyApi) {

    @CheckResult
    fun getTrending
}