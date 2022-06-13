package com.cai.base.binding.base

import android.app.Activity
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.viewbinding.ViewBinding
import com.cai.base.binding.ext.observerWhenDestroyed
import com.cai.base.binding.ext.registerLifecycleBelowQ
import kotlin.properties.ReadOnlyProperty


abstract class ActivityDelegate<T : ViewBinding>(
    activity: Activity
) : ReadOnlyProperty<Activity, T> {

    protected var viewBinding: T? = null
    private val LIFECYCLE_FRAGMENT_TAG = "com.cai.base.binding.lifecycle_fragment"

    init {
        when (activity) {
            is ComponentActivity -> activity.lifecycle.observerWhenDestroyed { destroyed() }
            else -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    activity.observerWhenDestroyed { destroyed() }
                }
            }
        }

    }

    fun addLifecycleFragment(activity: Activity) {
        activity.registerLifecycleBelowQ {
            destroyed()
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}