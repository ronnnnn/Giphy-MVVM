package com.ronnnnn.giphy_architecture_component.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronnnnn.giphy_architecture_component.R

/**
 * Created by kokushiseiya on 2017/11/03.
 */
class MainFragment : Fragment() {

    companion object {

        fun createInstance(): Fragment = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_main, container, false).apply {
                findViewById<ViewPager>(R.id.container_view_pager).run {
                    adapter = MainFragmentPagerAdapter(childFragmentManager)
                }
            }
}