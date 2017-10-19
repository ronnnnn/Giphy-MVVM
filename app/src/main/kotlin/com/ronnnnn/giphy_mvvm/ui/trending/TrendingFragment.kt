package com.ronnnnn.giphy_mvvm.ui.trending

import android.content.Context
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

    private var listener: Listener? = null
    private var recyclerAdapter: TrendingRecyclerAdapter? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        listener = activity as Listener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentTrendingBinding>(inflater, R.layout.fragment_trending, container, false).run {
                recyclerAdapter = TrendingRecyclerAdapter(context, object : TrendingRecyclerAdapter.Listener {
                    override fun onItemClicked(gifId: String) {
                        listener?.onItemClicked(gifId)
                    }
                })
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

    interface Listener {
        fun onItemClicked(gifId: String)
    }
}