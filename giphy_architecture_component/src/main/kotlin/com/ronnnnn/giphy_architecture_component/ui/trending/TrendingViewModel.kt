package com.ronnnnn.giphy_architecture_component.ui.trending

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ronnnnn.giphy_architecture_component.domain.trending.GetTrendingGifsUseCase
import com.ronnnnn.giphy_architecture_component.ui.BaseViewModel
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

/**
 * Created by kokushiseiya on 2017/11/05.
 */
class TrendingViewModel(getTrendingGifsUseCase: GetTrendingGifsUseCase) : BaseViewModel() {

    val gifs: MutableLiveData<List<Gif>> = MutableLiveData()

    init {
        getTrendingGifsUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ gifList -> gifs.value = gifList }, Timber::e)
                .let { disposable.add(it) }
    }
}