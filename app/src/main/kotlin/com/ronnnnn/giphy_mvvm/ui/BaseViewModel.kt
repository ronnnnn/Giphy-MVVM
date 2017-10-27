package com.ronnnnn.giphy_mvvm.ui

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by kokushiseiya on 2017/10/27.
 */
open class BaseViewModel {

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun dispose() {
        compositeDisposable.clear()
    }
}