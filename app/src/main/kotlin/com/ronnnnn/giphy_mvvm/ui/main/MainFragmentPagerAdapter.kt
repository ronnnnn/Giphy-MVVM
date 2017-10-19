package com.ronnnnn.giphy_mvvm.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ronnnnn.giphy_mvvm.ui.trending.TrendingFragment

/**
 * Created by kokushiseiya on 2017/10/13.
 */
class MainFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragments = arrayOf(TrendingFragment.createInstance())

    override fun getCount(): Int =
            fragments.size

    override fun getItem(position: Int): Fragment =
            fragments[position]
}