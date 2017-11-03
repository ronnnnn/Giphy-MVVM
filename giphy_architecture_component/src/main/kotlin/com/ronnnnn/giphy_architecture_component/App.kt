package com.ronnnnn.giphy_architecture_component

import android.app.Application
import android.content.Context
import com.ronnnnn.giphy_architecture_component.di.AppComponent
import com.ronnnnn.giphy_architecture_component.di.AppDataModule
import com.ronnnnn.giphy_architecture_component.di.AppModule
import com.ronnnnn.giphy_architecture_component.di.DaggerAppComponent
import timber.log.Timber

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

        Timber.plant(Timber.DebugTree())
    }
}