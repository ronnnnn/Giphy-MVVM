package com.ronnnnn.giphy_architecture_component.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ronnnnn.giphy_architecture_component.ui.trending.TrendingFragment

/**
 * Created by kokushiseiya on 2017/11/03.
 */
class MainFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val fragments = arrayOf(TrendingFragment.createInstance())

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]

}