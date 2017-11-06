package com.ronnnnn.giphy_architecture_component.domain.detail

import android.support.annotation.CheckResult
import com.ronnnnn.giphy_architecture_component.model.GiphyModel
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/11/06.
 */
@Singleton
class GetGifByIdUseCase @Inject constructor(private val giphyModel: GiphyModel) {

    @CheckResult
    fun execute(gifId: String): Single<Gif> =
            giphyModel.getGifById(gifId)
                    .map { searchById -> searchById.gif }
}