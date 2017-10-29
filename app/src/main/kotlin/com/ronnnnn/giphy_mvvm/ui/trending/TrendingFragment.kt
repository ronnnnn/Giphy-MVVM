package com.ronnnnn.giphy_mvvm.ui.trending

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView.scrollStateChanges
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import com.ronnnnn.giphy_mvvm.databinding.FragmentTrendingBinding
import com.ronnnnn.giphy_mvvm.ui.detail.DetailFragment
import com.ronnnnn.giphy_mvvm.ui.helper.addScrollFilter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by kokushiseiya on 2017/10/13.
 */
class TrendingFragment private constructor() : Fragment(), TrendingContract, TrendingRecyclerAdapter.Listener {

    companion object {
        fun createInstance(): Fragment = TrendingFragment()
    }

    private var recyclerAdapter: TrendingRecyclerAdapter? = null
    private var trendingViewModel: TrendingViewModel? = null

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentTrendingBinding>(inflater, R.layout.fragment_trending, container, false).run {
                trendingViewModel = TrendingViewModel(context, this@TrendingFragment)
                viewModel = trendingViewModel

                recyclerAdapter = TrendingRecyclerAdapter(context, this@TrendingFragment)
                trendingRecyclerView.run {
                    layoutManager = LinearLayoutManager(context)
                    adapter = recyclerAdapter
                    val disposable = scrollStateChanges(this)
                            .observeOn(AndroidSchedulers.mainThread())
                            .addScrollFilter(layoutManager as LinearLayoutManager)
                            .subscribe {
                                trendingViewModel?.fetchNextImages()
                            }
                    compositeDisposable.add(disposable)
                }

                root
            }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.clear()
        trendingViewModel?.dispose()
    }

    override fun showImages(images: List<Gif>) {
        recyclerAdapter?.setItemsAndNotify(images)
    }

    override fun addImages(images: List<Gif>) {
        recyclerAdapter?.addItemsAndNotify(images)
    }

    override fun onItemClicked(gifId: String, sharedImageView: ImageView) {
        activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_frame_layout, DetailFragment.createInstance(gifId))
                .addToBackStack(DetailFragment::class.java.name)
                .commit()
    }
}