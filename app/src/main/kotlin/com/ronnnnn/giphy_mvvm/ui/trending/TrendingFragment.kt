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

/**
 * Created by kokushiseiya on 2017/10/13.
 */
class TrendingFragment private constructor() : Fragment(), TrendingContract {

    companion object {

        fun createInstance(): Fragment =
                TrendingFragment()
    }

    private lateinit var binding: FragmentTrendingBinding

    private var recyclerAdapter: TrendingRecyclerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate<FragmentTrendingBinding>(inflater, R.layout.fragment_trending, container, false).apply {
            viewModel = TrendingViewModel(context, this@TrendingFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerAdapter = TrendingRecyclerAdapter(context)
        binding.trendingRecyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }
    }

    override fun showImages(images: List<Gif>) {
        recyclerAdapter?.setItemsAndNotify(images)
    }
}