package com.ronnnnn.giphy_architecture_component.ui.detail

import com.ronnnnn.giphy_architecture_component.di.AppComponent
import com.ronnnnn.giphy_architecture_component.di.FragmentScope
import dagger.Component

/**
 * Created by kokushiseiya on 2017/11/06.
 */
@FragmentScope
@Component(
        dependencies = arrayOf(AppComponent::class)
)
interface Component {

    fun inject(detailFragment: DetailFragment)
}