package com.ronnnnn.giphy_mvvm.ui.trending

import com.ronnnnn.giphy_mvvm.di.AppComponent
import com.ronnnnn.giphy_mvvm.di.ViewModelScope

/**
 * Created by kokushiseiya on 2017/10/19.
 */
@ViewModelScope
@dagger.Component(
        dependencies = arrayOf(AppComponent::class)
)
interface Component {

    fun inject(trendingViewModel: TrendingViewModel)
}