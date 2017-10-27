package com.ronnnnn.giphy_mvvm.ui.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.databinding.FragmentDetailBinding

/**
 * Created by kokushiseiya on 2017/10/19.
 */
class DetailFragment : Fragment(), DetailContract {

    companion object {
        private const val KEY_GIF_ID = "key_gif_id"

        fun createInstance(gifId: String): Fragment =
                DetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(KEY_GIF_ID, gifId)
                    }
                }
    }

    private var detailViewModel: DetailViewModel? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false).run {
                detailViewModel = DetailViewModel(context, this@DetailFragment).apply {
                    loadData(arguments.getString(KEY_GIF_ID))
                }
                viewModel = detailViewModel

                root
            }

    override fun onDestroy() {
        super.onDestroy()

        detailViewModel?.dispose()
    }
}