package com.ronnnnn.giphy_mvvm.ui.helper

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.functions.Predicate

/**
 * Created by kokushiseiya on 2017/10/27.
 */
object RxBindingHelper {
    const val SCROLL_GAP = 1

    fun scrollFilter(layoutManager: LinearLayoutManager, gap: Int = SCROLL_GAP): Predicate<Int> =
            Predicate {
                if (it != RecyclerView.SCROLL_STATE_IDLE) {
                    return@Predicate false
                }
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                return@Predicate (visibleItemCount + pastVisibleItems + gap >= totalItemCount)
            }
}

fun Observable<Int>.addScrollFilter(
        layoutManager: LinearLayoutManager,
        gap: Int = RxBindingHelper.SCROLL_GAP
): Observable<Int> =
        this.distinctUntilChanged().filter(RxBindingHelper.scrollFilter(layoutManager, gap))