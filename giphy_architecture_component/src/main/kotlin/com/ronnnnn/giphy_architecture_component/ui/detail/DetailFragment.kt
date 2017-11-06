package com.ronnnnn.giphy_architecture_component.ui.detail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronnnnn.giphy_architecture_component.App
import com.ronnnnn.giphy_architecture_component.R
import com.ronnnnn.giphy_architecture_component.databinding.FragmentDetailBinding
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2017/11/06.
 */
class DetailFragment : Fragment() {

    companion object {
        private const val KEY_GIF_ID = "key_gif_id"

        fun createInstance(gifId: String): Fragment =
                DetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(KEY_GIF_ID, gifId)
                    }
                }
    }

    private val component: Component by lazy {
        DaggerComponent.builder()
                .appComponent(App.get(context).component)
                .build()
    }

    @Inject
    lateinit var detailViewModelFactory: DetailViewModelFactory

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        component.inject(this)

        val gifId = arguments.getString(KEY_GIF_ID)

        DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false).run {
            val detailViewModel = ViewModelProviders.of(this@DetailFragment, detailViewModelFactory)
                    .get(DetailViewModel::class.java)
                    .apply {
                        fetchGif(gifId)
                    }
            viewModel = detailViewModel

            return root
        }
    }
}