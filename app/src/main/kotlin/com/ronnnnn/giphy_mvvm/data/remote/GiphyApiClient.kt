package com.ronnnnn.giphy_mvvm.data.remote

import com.ronnnnn.giphy_mvvm.data.json.TrendingJson
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/10/13.
 */
@Singleton
class GiphyApiClient @Inject constructor(retrofit: Retrofit) : GiphyApi {

    private val service: Service = retrofit.create(Service::class.java)

    override fun getTrending(apiKey: String,
                             limit: Int,
                             offset: Int,
                             rating: String,
                             format: String): Single<TrendingJson> =
            service.getTrending(apiKey, limit, offset, rating, format)

    interface Service {

        @GET("/v1/gifs/trending")
        fun getTrending(
                @Query("api_key") apiKey: String,
                @Query("limit") limit: Int,
                @Query("offset") offset: Int,
                @Query("rating") rating: String,
                @Query("fmt") format: String
        ): Single<TrendingJson>
    }
}