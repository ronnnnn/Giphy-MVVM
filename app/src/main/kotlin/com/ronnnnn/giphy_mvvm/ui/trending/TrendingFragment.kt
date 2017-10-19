package com.ronnnnn.giphy_mvvm.ui.trending

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import com.ronnnnn.giphy_mvvm.databinding.FragmentTrendingBinding
import com.ronnnnn.giphy_mvvm.ui.detail.DetailFragment
import com.ronnnnn.giphy_mvvm.ui.transition.DetailsTransition

/**
 * Created by kokushiseiya on 2017/10/13.
 */
class TrendingFragment private constructor() : Fragment(), TrendingContract, TrendingRecyclerAdapter.Listener {

    companion object {
        private const val SHARED_NAME = "shared_name"

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

    override fun onItemClicked(gifId: String, sharedImageView: ImageView) {
        val fragment = DetailFragment.createInstance(gifId).apply {
            sharedElementEnterTransition = DetailsTransition()
            enterTransition = Fade()
            this@TrendingFragment.exitTransition = Fade()
            sharedElementReturnTransition = DetailsTransition()
        }

        activity.supportFragmentManager
                .beginTransaction()
                .addSharedElement(sharedImageView, getString(R.string.transition_item_name_trending))
                .replace(R.id.container_frame_layout, fragment)
                .addToBackStack(DetailFragment::class.java.name)
                .commit()
    }
}