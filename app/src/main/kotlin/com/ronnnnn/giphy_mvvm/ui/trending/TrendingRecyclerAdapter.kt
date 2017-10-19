package com.ronnnnn.giphy_mvvm.ui.trending

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import com.ronnnnn.giphy_mvvm.databinding.ItemTrendingRecyclerViewBinding

/**
 * Created by kokushiseiya on 2017/10/17.
 */
class TrendingRecyclerAdapter(
        private val context: Context,
        private val listener: Listener
) : RecyclerView.Adapter<TrendingRecyclerAdapter.ViewHolder>() {

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
                ViewHolder(this).apply {
                    viewModel = this
                }
            }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadItem(gifs[position], position)
    }

    fun setItemsAndNotify(items: List<Gif>) {
        gifs.clear()
        gifs.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemTrendingRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        val gifId: ObservableField<String> = ObservableField()
        val imageUrl: ObservableField<String> = ObservableField()

        fun loadItem(gif: Gif, position: Int) {
            ViewCompat.setTransitionName(
                    binding.gifImageView,
                    context.getString(R.string.transition_item_name_trending_item, position)
            )

            gifId.set(gif.id)
            imageUrl.set(gif.images.fixedHeight.url)
        }

        fun startDetail(gifId: String) {
            listener.onItemClicked(gifId, binding.gifImageView)
        }
    }

    interface Listener {
        fun onItemClicked(gifId: String, sharedImageView: ImageView)
    }
}