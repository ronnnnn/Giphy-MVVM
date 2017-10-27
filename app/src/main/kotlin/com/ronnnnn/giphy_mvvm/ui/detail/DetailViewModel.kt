package com.ronnnnn.giphy_mvvm.ui.detail

import android.content.Context
import android.databinding.ObservableField
import android.view.View
import com.ronnnnn.giphy_mvvm.App
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import com.ronnnnn.giphy_mvvm.model.GiphyModel
import com.ronnnnn.giphy_mvvm.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2017/10/19.
 */
class DetailViewModel(private val context: Context, private val view: DetailContract): BaseViewModel() {

    @Inject
    lateinit var giphyModel: GiphyModel

    private val component: Component by lazy {
        DaggerComponent.builder()
                .appComponent(App.get(context).component)
                .build()
    }

    val gifImageUrl: ObservableField<String> = ObservableField()
    val userImageUrl: ObservableField<String> = ObservableField()
    val userName: ObservableField<String> = ObservableField()
    val userTwitterId: ObservableField<String> = ObservableField()
    val twitterIdVisibility: ObservableField<Int> = ObservableField()

    init {
        component.inject(this)
    }

    fun loadData(gifId: String) {
        val disposable = giphyModel.getGifById(gifId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result, throwable ->
                    throwable?.let {
                        Timber.e(it)
                    } ?: kotlin.run {
                        setData(result.gif)
                    }
                }
        compositeDisposable.add(disposable)
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