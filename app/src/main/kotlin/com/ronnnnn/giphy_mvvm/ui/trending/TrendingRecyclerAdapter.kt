package com.ronnnnn.giphy_mvvm.ui.trending

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.ronnnnn.giphy_mvvm.R
import com.ronnnnn.giphy_mvvm.data.json.response.gif.Gif
import com.ronnnnn.giphy_mvvm.databinding.ItemTrendingRecyclerView1Binding
import com.ronnnnn.giphy_mvvm.databinding.ItemTrendingRecyclerView2Binding
import com.ronnnnn.giphy_mvvm.databinding.ItemTrendingRecyclerView3Binding

/**
 * Created by kokushiseiya on 2017/10/17.
 */
class TrendingRecyclerAdapter(
        private val context: Context,
        private val listener: Listener
) : RecyclerView.Adapter<TrendingRecyclerAdapter.BaseViewHolder>() {

    private companion object {
        private const val ITEM_VIEW_TYPE_1 = 0
        private const val ITEM_VIEW_TYPE_2 = 1
        private const val ITEM_VIEW_TYPE_3 = 2

        private const val MIN_ITEM_COUNT = 3
        private const val MAX_ITEM_COUNT = 6
        private const val TOTAL_ITEM_COUNT = MIN_ITEM_COUNT * 2 + MAX_ITEM_COUNT
    }

    private val gifs: ArrayList<Gif> = arrayListOf()

    override fun getItemCount(): Int {
        if (gifs.isEmpty()) return 0

        return when (gifs.size % TOTAL_ITEM_COUNT) {
            in 0..(MIN_ITEM_COUNT - 1) -> gifs.size / TOTAL_ITEM_COUNT * MIN_ITEM_COUNT
            in (MIN_ITEM_COUNT + MAX_ITEM_COUNT)..(TOTAL_ITEM_COUNT - 1) -> {
                val index = (gifs.size + MIN_ITEM_COUNT) / TOTAL_ITEM_COUNT
                MIN_ITEM_COUNT * index - 1
            }
            else -> {
                val index = (gifs.size + MIN_ITEM_COUNT + MAX_ITEM_COUNT) / TOTAL_ITEM_COUNT
                MIN_ITEM_COUNT * index - 2
            }
        }
    }

    override fun getItemViewType(position: Int): Int = position % 3

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        when (viewType) {
            ITEM_VIEW_TYPE_1 -> return DataBindingUtil.inflate<ItemTrendingRecyclerView1Binding>(
                    LayoutInflater.from(context),
                    R.layout.item_trending_recycler_view_1,
                    parent,
                    false
            ).let {
                FirstGridViewHolder(it).apply {
                    it.viewModel = this
                }
            }

            ITEM_VIEW_TYPE_2 -> return DataBindingUtil.inflate<ItemTrendingRecyclerView2Binding>(
                    LayoutInflater.from(context),
                    R.layout.item_trending_recycler_view_2,
                    parent,
                    false
            ).let {
                SecondGridViewHolder(it).apply {
                    it.viewModel = this
                }
            }

            else -> return DataBindingUtil.inflate<ItemTrendingRecyclerView3Binding>(
                    LayoutInflater.from(context),
                    R.layout.item_trending_recycler_view_3,
                    parent,
                    false
            ).let {
                ThirdGridViewHolder(it).apply {
                    it.viewModel = this
                }
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val viewType = position % 3
        val viewPosition = position / 3
        when (viewType) {
            ITEM_VIEW_TYPE_1 -> {
                val startIndex = viewPosition * 12
                val endIndex = startIndex + MIN_ITEM_COUNT - 1
                val list = (startIndex..endIndex).map { index -> gifs[index] }
                holder.loadItem(list, position)
            }

            ITEM_VIEW_TYPE_2 -> {
                val startIndex = viewPosition * 12 + MIN_ITEM_COUNT
                val endIndex = startIndex + MAX_ITEM_COUNT - 1
                val list = (startIndex..endIndex).map { index -> gifs[index] }
                holder.loadItem(list, position)
            }

            ITEM_VIEW_TYPE_3 -> {
                val startIndex = viewPosition * 12 + MIN_ITEM_COUNT + MAX_ITEM_COUNT
                val endIndex = startIndex + MIN_ITEM_COUNT - 1
                val list = (startIndex..endIndex).map { index -> gifs[index] }
                holder.loadItem(list, position)
            }
        }
    }

    fun setItemsAndNotify(items: List<Gif>) {
        gifs.clear()
        gifs.addAll(items)
        notifyDataSetChanged()
    }

    fun addItemsAndNotify(items: List<Gif>) {
        gifs.addAll(items)
        notifyDataSetChanged()
    }

    inner abstract class BaseViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        abstract fun loadItem(gifs: List<Gif?>, position: Int)

        fun startDetail(gifId: String, viewId: Int) {
            listener.onItemClicked(gifId, binding.root.findViewById(viewId))
        }
    }

    inner class FirstGridViewHolder(private val binding: ItemTrendingRecyclerView1Binding) : BaseViewHolder(binding) {

        val gifIds: List<ObservableField<String?>> = listOf(ObservableField(), ObservableField(), ObservableField())
        val imageUrls: List<ObservableField<String?>> = listOf(ObservableField(), ObservableField(), ObservableField())

        override fun loadItem(gifs: List<Gif?>, position: Int) {
            gifs.map { gif -> gif?.id }
                    .forEachIndexed { index, id ->
                        gifIds[index].set(id)
                    }
            gifs.map { gif -> gif?.images?.fixedHeightDownsampled?.url }
                    .forEachIndexed { index, url ->
                        imageUrls[index].set(url)
                    }
        }
    }

    inner class SecondGridViewHolder(private val binding: ItemTrendingRecyclerView2Binding) : BaseViewHolder(binding) {
        val gifIds: List<ObservableField<String>> = listOf(ObservableField(), ObservableField(), ObservableField(), ObservableField(), ObservableField(), ObservableField())
        val imageUrls: List<ObservableField<String>> = listOf(ObservableField(), ObservableField(), ObservableField(), ObservableField(), ObservableField(), ObservableField())

        override fun loadItem(gifs: List<Gif?>, position: Int) {
            gifs.map { gif -> gif?.id }
                    .forEachIndexed { index, id ->
                        gifIds[index].set(id)
                    }
            gifs.map { gif -> gif?.images?.fixedHeightDownsampled?.url }
                    .forEachIndexed { index, Url ->
                        imageUrls[index].set(Url)
                    }
        }
    }

    inner class ThirdGridViewHolder(private val binding: ItemTrendingRecyclerView3Binding) : BaseViewHolder(binding) {

        val gifIds: List<ObservableField<String?>> = listOf(ObservableField(), ObservableField(), ObservableField())
        val imageUrls: List<ObservableField<String?>> = listOf(ObservableField(), ObservableField(), ObservableField())

        override fun loadItem(gifs: List<Gif?>, position: Int) {
            gifs.map { gif -> gif?.id }
                    .forEachIndexed { index, id ->
                        gifIds[index].set(id)
                    }
            gifs.map { gif -> gif?.images?.fixedHeightDownsampled?.url }
                    .forEachIndexed { index, Url ->
                        imageUrls[index].set(Url)
                    }
        }
    }

    interface Listener {
        fun onItemClicked(gifId: String, sharedImageView: ImageView)
    }
}