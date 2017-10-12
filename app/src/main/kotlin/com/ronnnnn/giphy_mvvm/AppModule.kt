package com.ronnnnn.giphy_mvvm

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by kokushiseiya on 2017/10/11.
 */
@Module(includes = arrayOf())
class AppModule(private val app: App) {

    @Provides
    fun provideApplication(): Application = app

    @Provides
    fun provideContext(): Context = app.applicationContext
}