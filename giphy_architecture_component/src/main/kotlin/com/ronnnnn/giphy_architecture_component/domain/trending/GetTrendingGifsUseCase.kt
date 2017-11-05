package com.ronnnnn.giphy_architecture_component.domain.trending

import com.ronnnnn.giphy_architecture_component.model.GiphyModel
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2017/11/05.
 */
@Singleton
class GetTrendingGifsUseCase @Inject constructor(private val giphyModel: GiphyModel) {

    fun execute(offset: Int = 0, limit: Int = 25, rating: String = "", format: String = ""): Single<List<Gif>> =
        giphyModel.getTrending(offset, limit, rating, format)
                .map { trending -> trending.gifs }
}