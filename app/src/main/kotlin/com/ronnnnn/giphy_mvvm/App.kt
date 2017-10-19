package com.ronnnnn.giphy_mvvm

import android.app.Application
import android.content.Context
import com.ronnnnn.giphy_mvvm.di.AppComponent
import com.ronnnnn.giphy_mvvm.di.AppDataModule
import com.ronnnnn.giphy_mvvm.di.AppModule
import com.ronnnnn.giphy_mvvm.di.DaggerAppComponent

/**
 * Created by kokushiseiya on 2017/10/11.
 */
class App : Application() {

    companion object {
        fun get(context: Context) = context.applicationContext as App
    }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .appDataModule(AppDataModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}