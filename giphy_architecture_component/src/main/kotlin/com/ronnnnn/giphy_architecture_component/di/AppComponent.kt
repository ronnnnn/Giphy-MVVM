package com.ronnnnn.giphy_architecture_component.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.ronnnnn.giphy_architecture_component.App
import com.ronnnnn.giphy_architecture_component.domain.trending.GetTrendingGifsUseCase
import com.ronnnnn.giphy_architecture_component.model.GiphyModel
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/10/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, AppDataModule::class))
interface AppComponent {

    fun inject(app: App)

    fun application(): Application

    fun context(): Context

    fun sharedPreferences(): SharedPreferences

    fun okHttpClient(): OkHttpClient

    fun retrofit(): Retrofit

    fun giphyModel(): GiphyModel

    fun getTrendingGifUseCase(): GetTrendingGifsUseCase
}