package com.ronnnnn.giphy_architecture_component.ui.trending

import com.ronnnnn.giphy_architecture_component.di.AppComponent
import com.ronnnnn.giphy_architecture_component.di.FragmentScope

/**
 * Created by kokushiseiya on 2017/10/19.
 */
@FragmentScope
@dagger.Component(
        dependencies = arrayOf(AppComponent::class)
)
interface Component {

    fun inject(trendingFragment: TrendingFragment)
}