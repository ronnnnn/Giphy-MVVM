package com.ronnnnn.giphy_mvvm.ui.trending

import android.content.Context
import com.ronnnnn.giphy_mvvm.App
import com.ronnnnn.giphy_mvvm.model.GiphyModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2017/10/17.
 */
class TrendingViewModel(private val context: Context, private val view: TrendingContract) {

    @Inject
    lateinit var giphyModel: GiphyModel

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
        giphyModel.getTrending()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { trending, throwable ->
                    throwable?.let {
                        Timber.e(it)
                    } ?: kotlin.run {
                        trending.gifs.let {
                            view.showImages(it)
                        }
                    }
                }
    }
}