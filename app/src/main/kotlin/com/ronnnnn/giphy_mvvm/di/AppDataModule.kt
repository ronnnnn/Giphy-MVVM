package com.ronnnnn.giphy_mvvm.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.ronnnnn.giphy_mvvm.data.GiphyModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/10/12.
 */
@Module(includes = arrayOf(GiphyModule::class))
class AppDataModule {

    companion object {
        private const val PREFERENCE_NAME = "giphy-mvvm"
        private const val ENDPOINT = "http://api.giphy.com/"
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences =
            application.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .client(client)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
}