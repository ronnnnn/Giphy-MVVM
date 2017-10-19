package com.ronnnnn.giphy_mvvm.ui.trending

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import com.ronnnnn.giphy_mvvm.databinding.FragmentTrendingBinding
import com.ronnnnn.giphy_mvvm.ui.detail.DetailFragment

/**
 * Created by kokushiseiya on 2017/10/13.
 */
class TrendingFragment private constructor() : Fragment(), TrendingContract, TrendingRecyclerAdapter.Listener {

    companion object {

        fun createInstance(): Fragment = TrendingFragment()
    }

    private var recyclerAdapter: TrendingRecyclerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentTrendingBinding>(inflater, R.layout.fragment_trending, container, false).run {
                recyclerAdapter = TrendingRecyclerAdapter(context, this@TrendingFragment)
                trendingRecyclerView.run {
                    layoutManager = LinearLayoutManager(context)
                    adapter = recyclerAdapter
                }
                viewModel = TrendingViewModel(context, this@TrendingFragment)

                root
            }

    override fun showImages(images: List<Gif>) {
        recyclerAdapter?.setItemsAndNotify(images)
    }

    override fun onItemClicked(gifId: String) {
        activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_frame_layout, DetailFragment.createInstance(gifId))
                .addToBackStack(DetailFragment::class.java.name)
                .commit()
    }
}