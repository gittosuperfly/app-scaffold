package com.cai.architecture.ui.databinding

import android.util.SparseArray

class DataBindingConfig constructor(val layoutId: Int) {
    val params: SparseArray<Any> = SparseArray()
    fun addParam(bindingParamId: Int, obj: Any) = this.apply {
        if (params[bindingParamId] == null) {
            params[bindingParamId] = obj
        }
    }
}