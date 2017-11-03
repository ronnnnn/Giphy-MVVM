package com.ronnnnn.giphy_architecture_component.di

import android.app.Application
import android.content.Context
import com.ronnnnn.giphy_architecture_component.App
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