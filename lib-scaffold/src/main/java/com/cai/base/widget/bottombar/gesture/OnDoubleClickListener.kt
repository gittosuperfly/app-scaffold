package com.cai.base.widget.bottombar.gesture

import android.view.MotionEvent
import android.view.View
import androidx.annotation.RestrictTo


@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal class OnDoubleClickListener @JvmOverloads constructor(
    enableAll: Boolean = true,
    view: View,
    private val onDoubleClick: () -> Unit
) : BaseGestureListener(enableAll, view) {

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        onDoubleClick.invoke()
        return true
    }

}