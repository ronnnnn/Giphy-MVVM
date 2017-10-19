package com.ronnnnn.giphy_mvvm.ui.transition

import android.os.Build
import android.transition.*

/**
 * Created by kokushiseiya on 2017/10/19.
 */
class DetailsTransition : TransitionSet() {

    init {
        ordering = ORDERING_TOGETHER

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            addTransition(ChangeBounds())
                    .addTransition(ChangeTransform())
                    .addTransition(ChangeImageTransform())
        } else {
            addTransition(ChangeBounds())
                    .addTransition(AutoTransition())
        }
    }
}