package com.ronnnnn.giphy_architecture_component.ui.detail

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View
import com.ronnnnn.giphy_architecture_component.domain.detail.GetGifByIdUseCase
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

/**
 * Created by kokushiseiya on 2017/11/06.
 */
class DetailViewModel(private val getGifByIdUseCase: GetGifByIdUseCase) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    val gifImageUrl: ObservableField<String> = ObservableField()
    val userImageUrl: ObservableField<String> = ObservableField()
    val userName: ObservableField<String> = ObservableField()
    val userTwitterId: ObservableField<String> = ObservableField()
    val twitterIdVisibility: ObservableField<Int> = ObservableField()

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }

    fun fetchGif(gifId: String) {
        getGifByIdUseCase.execute(gifId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ gif -> setData(gif) }, Timber::e)
                .let { disposable.add(it) }
    }

    private fun setData(gif: Gif) {
        gifImageUrl.set(gif.images.fixedHeight.url)
        gif.user?.let {
            userImageUrl.set(it.avatarUrl)
            userName.set(it.displayName)
            it.twitter?.let {
                userTwitterId.set(it)
                twitterIdVisibility.set(View.VISIBLE)
            } ?: kotlin.run {
                twitterIdVisibility.set(View.GONE)
            }
        } ?: kotlin.run {
            // do something if no user data
        }
    }
}