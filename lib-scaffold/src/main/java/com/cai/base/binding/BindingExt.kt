package com.cai.base.binding

import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.cai.base.binding.databind.*
import com.cai.base.binding.viewbind.*


inline fun <reified T : ViewDataBinding> Fragment.dataBinding() =
    FragmentDataBinding<T>(T::class.java, this)

inline fun <reified T : ViewDataBinding> Fragment.dataBinding(noinline block: T.() -> Unit) =
    FragmentDataBinding<T>(T::class.java, this, block = block)

inline fun <reified T : ViewDataBinding> Activity.dataBinding(@LayoutRes resId: Int) =
    ActivityDataBinding<T>(this, resId)

inline fun <reified T : ViewDataBinding> Dialog.dataBinding(
    @LayoutRes resId: Int
) = DialogDataBinding(
    classes = T::class.java,
    inflater = this.layoutInflater,
    resId = resId,
)

inline fun <reified T : ViewDataBinding> Activity.dataBinding(
    @LayoutRes resId: Int,
    noinline block: T.() -> Unit
) = ActivityDataBinding<T>(this, resId, block)

inline fun <reified T : ViewDataBinding> Dialog.dataBinding(
    @LayoutRes resId: Int,
    noinline block: T.() -> Unit
) = DialogDataBinding(
    classes = T::class.java,
    inflater = this.layoutInflater,
    resId = resId,
    block = block,
)

inline fun <reified T : ViewDataBinding> Dialog.dataBinding(
    @LayoutRes resId: Int,
    lifecycle: Lifecycle
) = DialogDataBinding(
    classes = T::class.java,
    inflater = this.layoutInflater,
    resId = resId,
    lifecycle = lifecycle
)

inline fun <reified T : ViewDataBinding> RecyclerView.ViewHolder.dataBinding() =
    ViewHolderDataBinding(T::class.java)

inline fun <reified T : ViewDataBinding> RecyclerView.ViewHolder.dataBinding(noinline block: (T.() -> Unit)) =
    ViewHolderDataBinding(T::class.java, block)

inline fun <reified T : ViewBinding> ViewGroup.dataBinding(@LayoutRes resId: Int) =
    ViewGroupDataBinding(
        classes = T::class.java,
        resId = resId,
        inflater = LayoutInflater.from(getContext()),
        viewGroup = this
    )

inline fun <reified T : ViewBinding> ViewGroup.dataBinding(
    @LayoutRes resId: Int,
    noinline block: (T.() -> Unit)
) = ViewGroupDataBinding(
    classes = T::class.java,
    resId = resId,
    inflater = LayoutInflater.from(getContext()),
    viewGroup = this,
    block = block
)

inline fun <reified T : ViewBinding> Activity.viewBinding() =
    ActivityViewBinding(T::class.java, this)

//inline fun <reified T : ViewBinding> AppCompatActivity.viewbind() =
//    ActivityViewBinding(T::class.java, this)
//
//inline fun <reified T : ViewBinding> FragmentActivity.viewbind() =
//    ActivityViewBinding(T::class.java, this)

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    FragmentViewBinding(T::class.java, this)

inline fun <reified T : ViewBinding> Dialog.viewBinding() =
    DialogViewBinding(T::class.java)

inline fun <reified T : ViewBinding> Dialog.viewBinding(lifecycle: Lifecycle) =
    DialogViewBinding(T::class.java, lifecycle)

inline fun <reified T : ViewBinding> RecyclerView.ViewHolder.viewBinding() =
    ViewHolderViewBinding(T::class.java)

inline fun <reified T : ViewBinding> ViewGroup.viewBinding() = ViewGroupViewBinding(
    classes = T::class.java,
    inflater = LayoutInflater.from(getContext()),
    viewGroup = this
)

inline fun <reified T : ViewBinding> ViewGroup.viewBinding(viewGroup: ViewGroup) =
    ViewGroupViewBinding(
        classes = T::class.java,
        inflater = LayoutInflater.from(getContext()),
        viewGroup = viewGroup
    )