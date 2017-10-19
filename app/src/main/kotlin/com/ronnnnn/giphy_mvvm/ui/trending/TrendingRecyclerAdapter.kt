package com.ronnnnn.giphy_mvvm.ui.trending

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import com.ronnnnn.giphy_mvvm.databinding.ItemTrendingRecyclerViewBinding

/**
 * Created by kokushiseiya on 2017/10/17.
 */
class TrendingRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<TrendingRecyclerAdapter.ViewHolder>() {

    private val gifs: ArrayList<Gif> = arrayListOf()

    override fun getItemCount(): Int =
            gifs.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            DataBindingUtil.inflate<ItemTrendingRecyclerViewBinding>(
                    LayoutInflater.from(context),
                    R.layout.item_trending_recycler_view,
                    parent,
                    false
            ).run {
                viewModel = TrendingItemViewModel()
                ViewHolder(root, viewModel)
            }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(gifs[position])
    }

    fun setItemsAndNotify(items: List<Gif>) {
        gifs.clear()
        gifs.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View, private val viewModel: TrendingItemViewModel) : RecyclerView.ViewHolder(view) {

        fun onBind(gif: Gif) {
            viewModel.loadItem(gif)
        }
    }
}