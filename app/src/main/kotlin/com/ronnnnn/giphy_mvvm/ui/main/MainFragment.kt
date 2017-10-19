package com.ronnnnn.giphy_mvvm.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.databinding.FragmentMainBinding

/**
 * Created by kokushiseiya on 2017/10/19.
 */
class MainFragment : Fragment() {

    companion object {

        fun createInstance(): Fragment = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false).run {
                viewModel = MainFragmentViewModel()
                mainViewPager.adapter = MainFragmentPagerAdapter(childFragmentManager)

                root
            }
}