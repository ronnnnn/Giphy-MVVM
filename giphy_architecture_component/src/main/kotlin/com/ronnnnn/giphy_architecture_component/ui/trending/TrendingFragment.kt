package com.ronnnnn.giphy_architecture_component.ui.trending

import android.arch.lifecycle.*
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView
import com.ronnnnn.giphy_architecture_component.App
import com.ronnnnn.giphy_architecture_component.R
import com.ronnnnn.giphy_architecture_component.databinding.FragmentTrendingBinding
import com.ronnnnn.giphy_architecture_component.ui.detail.DetailFragment
import com.ronnnnn.giphy_architecture_conponent.ui.helper.addScrollFilter
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2017/11/03.
 */
class TrendingFragment : Fragment(), TrendingRecyclerAdapter.Listener {

    companion object {

        fun createInstance(): Fragment = TrendingFragment()
    }

    @Inject
    lateinit var trendingViewModelFactory: TrendingViewModelFactory

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val component: Component by lazy {
        DaggerComponent.builder()
                .appComponent(App.get(context).component)
                .build()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        component.inject(this)

        DataBindingUtil.inflate<FragmentTrendingBinding>(inflater, R.layout.fragment_trending, container, false).run {
            val trendingViewModel = ViewModelProviders.of(this@TrendingFragment, trendingViewModelFactory)
                    .get(TrendingViewModel::class.java)
            viewModel = trendingViewModel

            trendingRecyclerView.run {
                layoutManager = LinearLayoutManager(context)
                adapter = TrendingRecyclerAdapter(context, this@TrendingFragment)
                RxRecyclerView.scrollStateChanges(this)
                        .observeOn(AndroidSchedulers.mainThread())
                        .addScrollFilter(layoutManager as LinearLayoutManager)
                        .subscribe {
                            trendingViewModel.fetchGifs()
                        }
                        .let { disposable.add(it) }
            }

            lifecycle.addObserver(TrendingFragmentObserver())

            observeTrendingGifs(trendingViewModel, trendingRecyclerView)

            return root
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        disposable.clear()
    }

    private fun observeTrendingGifs(viewModel: TrendingViewModel, trendingRecyclerView: RecyclerView) {
        viewModel.gifs
                .observe(this,
                        Observer<List<Gif>> { gifs ->
                            gifs?.let { (trendingRecyclerView.adapter as TrendingRecyclerAdapter).addItemsAndNotify(it) }
                        })
    }

    override fun onItemClicked(gifId: String, sharedImageView: ImageView) {
        activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_frame_layout, DetailFragment.createInstance(gifId))
                .addToBackStack(DetailFragment::class.java.name)
                .commit()
    }

    inner class TrendingFragmentObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onStop() {
            ViewModelProviders.of(this@TrendingFragment, trendingViewModelFactory)
                    .get(TrendingViewModel::class.java)
                    .resetGifs()
        }
    }
}