package com.cai.base.binding.viewbind

import android.app.Activity
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.viewbinding.ViewBinding
import com.cai.base.binding.ext.inflateMethod
import com.cai.base.binding.ext.inflateMethodWithViewGroup
import com.cai.base.binding.ext.observerWhenDestroyed
import com.cai.base.binding.ext.registerLifecycleBelowQ
import java.lang.reflect.Method
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class ViewGroupViewBinding<T : ViewBinding>(
    classes: Class<T>,
    val inflater: LayoutInflater,
    val viewGroup: ViewGroup? = null
) : ReadOnlyProperty<ViewGroup, T> {

    private var viewBinding: T? = null
    private var layoutInflater: Method

    init {
        if (viewGroup != null) {
            layoutInflater = classes.inflateMethodWithViewGroup()
        } else {
            layoutInflater = classes.inflateMethod()
        }

        viewGroup?.apply {
            when (context) {
                is ComponentActivity -> {
                    (context as ComponentActivity).lifecycle.observerWhenDestroyed { destroyed() }
                }
                is Activity -> {
                    val activity = context as Activity
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        activity.observerWhenDestroyed { destroyed() }
                    } else {
                        activity.registerLifecycleBelowQ { destroyed() }
                    }
                }
            }
        }
    }

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind: T
            if (viewGroup != null) {
                bind = layoutInflater.invoke(null, inflater, viewGroup) as T
            } else {
                bind = layoutInflater.invoke(null, inflater) as T
            }

            bind.apply {
                if (viewGroup == null) {
                    thisRef.addView(bind.root)
                }
                viewBinding = this
            }
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}