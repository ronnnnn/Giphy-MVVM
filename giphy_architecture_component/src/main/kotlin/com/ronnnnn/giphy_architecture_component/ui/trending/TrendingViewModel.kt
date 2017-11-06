package com.ronnnnn.giphy_architecture_component.ui.trending

import android.arch.lifecycle.MutableLiveData
import com.ronnnnn.giphy_architecture_component.domain.trending.GetTrendingGifsUseCase
import com.ronnnnn.giphy_architecture_component.ui.BaseViewModel
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber

/**
 * Created by kokushiseiya on 2017/11/05.
 */
class TrendingViewModel(private val getTrendingGifsUseCase: GetTrendingGifsUseCase) : BaseViewModel() {

    val gifs: MutableLiveData<List<Gif>> = MutableLiveData()

    private var itemCount = 0

    init {
        fetchGifs()
    }

    fun fetchGifs() {
        getTrendingGifsUseCase.execute(itemCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ gifList ->
                    itemCount += gifList.size
                    gifs.value = gifList
                }, Timber::e)
                .let { disposable.add(it) }
    }

    fun resetGifs() {
        itemCount = 0
        fetchGifs()
    }
}