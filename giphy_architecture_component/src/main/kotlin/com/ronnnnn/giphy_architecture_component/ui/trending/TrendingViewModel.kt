package com.ronnnnn.giphy_architecture_component.ui.trending

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ronnnnn.giphy_architecture_component.domain.trending.GetTrendingGifsUseCase
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2017/11/05.
 */
class TrendingViewModel : ViewModel() {

    @Inject
    lateinit var getTrendingGifsUseCase: GetTrendingGifsUseCase

    val gifs: MutableLiveData<List<Gif>> = MutableLiveData()

    private val disposable: CompositeDisposable = CompositeDisposable()

    init {
        getTrendingGifsUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ gifList -> gifs.value = gifList }, Timber::e)
                .let { disposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }
}