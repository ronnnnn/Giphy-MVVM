package com.ronnnnn.giphy_architecture_component.ui.trending

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ronnnnn.giphy_architecture_component.domain.trending.GetTrendingGifsUseCase
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/11/06.
 */
@Singleton
class TrendingViewModelFactory @Inject constructor(private val getTrendingGifsUseCase: GetTrendingGifsUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrendingViewModel::class.java)) {
            return TrendingViewModel(getTrendingGifsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}