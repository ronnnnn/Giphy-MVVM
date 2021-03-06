package com.ronnnnn.giphy_mvvm.ui.trending

import android.content.Context
import com.ronnnnn.giphy_mvvm.App
import com.ronnnnn.giphy_mvvm.model.GiphyModel
import com.ronnnnn.giphy_mvvm.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2017/10/17.
 */
class TrendingViewModel(private val context: Context, private val view: TrendingContract): BaseViewModel() {

    @Inject
    lateinit var giphyModel: GiphyModel

    private var itemCount: Int = 0

    private val component: Component by lazy {
        DaggerComponent.builder()
                .appComponent(App.get(context).component)
                .build()
    }

    init {
        component.inject(this)
        fetchImages()
    }

    private fun fetchImages() {
        val disposable = giphyModel.getTrending()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { trending, throwable ->
                    throwable?.let {
                        Timber.e(it)
                    } ?: kotlin.run {
                        itemCount += trending.gifs.size
                        trending.gifs.let {
                            view.showImages(it)
                        }
                    }
                }
        compositeDisposable.add(disposable)
    }

    fun fetchNextImages() {
        val disposable = giphyModel.getTrending(itemCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { trending, throwable ->
                    throwable?.let {
                        Timber.e(it)
                    } ?: kotlin.run {
                        itemCount += trending.gifs.size
                        trending.gifs.let {
                            view.addImages(it)
                        }
                    }
                }
        compositeDisposable.add(disposable)
    }
}