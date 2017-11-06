package com.ronnnnn.giphy_architecture_component.ui

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by kokushiseiya on 2017/11/07.
 */
open class BaseViewModel: ViewModel() {

    protected val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }
}