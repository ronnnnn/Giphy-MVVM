package com.ronnnnn.giphy_architecture_component.ui.trending

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ronnnnn.giphy_architecture_component.R
import com.ronnnnn.giphy_architecture_component.databinding.FragmentTrendingBinding
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif

/**
 * Created by kokushiseiya on 2017/11/03.
 */
class TrendingFragment : Fragment(), TrendingRecyclerAdapter.Listener {

    companion object {

        fun createInstance(): Fragment = TrendingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentTrendingBinding>(inflater, R.layout.fragment_trending, container, false).run {
                val trendingViewModel = ViewModelProviders.of(this@TrendingFragment)
                        .get(TrendingViewModel::class.java)
                viewModel = trendingViewModel

                trendingRecyclerView.run {
                    layoutManager = LinearLayoutManager(context)
                    adapter = TrendingRecyclerAdapter(context, this@TrendingFragment)
                }

                observeTrendingGifs(trendingViewModel, trendingRecyclerView)

                root
            }

    private fun observeTrendingGifs(viewModel: TrendingViewModel, trendingRecyclerView: RecyclerView) {
        viewModel.gifs
                .observe(this,
                        Observer<List<Gif>> { gifs ->
                            (trendingRecyclerView.adapter as TrendingRecyclerAdapter).setItemsAndNotify(gifs)
                        })
    }

    override fun onItemClicked(gifId: String, sharedImageView: ImageView) {
        
    }
}