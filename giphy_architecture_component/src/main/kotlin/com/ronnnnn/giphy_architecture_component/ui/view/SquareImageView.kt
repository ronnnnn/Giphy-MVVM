package com.ronnnnn.giphy_architecture_component.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by kokushiseiya on 2017/10/21.
 */
class SquareImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(measuredWidth, measuredWidth)
    }
}