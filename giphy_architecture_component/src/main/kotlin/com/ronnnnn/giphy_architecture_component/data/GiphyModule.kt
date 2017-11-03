package com.ronnnnn.giphy_architecture_component.data

import com.ronnnnn.giphy_architecture_component.data.remote.GiphyApi
import com.ronnnnn.giphy_architecture_component.data.remote.GiphyApiClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/10/13.
 */
@Module
class GiphyModule {

    @Singleton
    @Provides
    fun provideGiphyApi(retrofit: Retrofit): GiphyApi =
            GiphyApiClient(retrofit)
}