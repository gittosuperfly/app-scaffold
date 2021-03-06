package com.cai.base.binding.ext

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.Fragment
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner


fun Lifecycle.observerWhenDestroyed(destroyed: () -> Unit) {
    addObserver(LifecycleObserver(lifecycle = this, destroyed = destroyed))
}

fun Lifecycle.observerWhenCreated(create: () -> Unit) {
    addObserver(LifecycleObserver(lifecycle = this, create = create))
}

class LifecycleObserver(
    var lifecycle: Lifecycle?,
    var destroyed: (() -> Unit)? = null,
    var create: (() -> Unit)? = null
) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        create?.invoke()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        destroyed?.invoke()
        lifecycle?.apply {
            removeObserver(this@LifecycleObserver)
            lifecycle = null
        }
        create = null
        destroyed = null
    }
}

fun Activity.observerWhenDestroyed(destroyed: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        registerActivityLifecycleCallbacks(LifecycleCallbacks(destroyed))
    }
}

class LifecycleCallbacks(var destroyed: (() -> Unit)? = null) :
    Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        destroyed?.invoke()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            activity.unregisterActivityLifecycleCallbacks(this)
        }
        destroyed = null
    }
}

class LifecycleFragment : Fragment {
    var destroyed: (() -> Unit)? = null

    constructor()

    @SuppressLint("ValidFragment")
    constructor(destroyed: () -> Unit) : this() {
        this.destroyed = destroyed
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyed?.invoke()
        destroyed = null
    }
}

/**
 * ????????? Activity ??? Build.VERSION.SDK_INT < Build.VERSION_CODES.Q ??????????????????
 * ??????????????? ????????? Fragment, ????????????????????? onDestroy ???????????????
 */
private const val LIFECYCLE_FRAGMENT_TAG = "com.cai.base.binding.lifecycle_fragment"
internal inline fun Activity.registerLifecycleBelowQ(crossinline destroyed: () -> Unit) {
    val activity = this
    if (activity is FragmentActivity || activity is AppCompatActivity) return

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) return

    val fragmentManager = activity.fragmentManager
    if (fragmentManager.findFragmentByTag(LIFECYCLE_FRAGMENT_TAG) == null) {
        val transaction = fragmentManager.beginTransaction()
        transaction.add(LifecycleFragment { destroyed() }, LIFECYCLE_FRAGMENT_TAG).commit()
        fragmentManager.executePendingTransactions()
    }
}
