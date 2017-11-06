package com.ronnnnn.giphy_architecture_component.ui.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ronnnnn.giphy_architecture_component.domain.detail.GetGifByIdUseCase
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/11/06.
 */
@Singleton
class DetailViewModelFactory @Inject constructor(private val getGifByIdUseCase: GetGifByIdUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(getGifByIdUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}