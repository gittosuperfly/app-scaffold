package com.cai.architecture.ui.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.cai.base.navigation.NavHostFragment

abstract class DataBindingFragment<BINDING : ViewDataBinding> : Fragment() {


    private var isBindingInit = false
    private var binding: BINDING? = null

    protected abstract fun getDataBindingConfig(): DataBindingConfig

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View? {
        val config: DataBindingConfig = getDataBindingConfig()
        binding = DataBindingUtil.inflate(inflater, config.layoutId, root, false)
        binding?.let { isBindingInit = true }
        binding?.lifecycleOwner = viewLifecycleOwner
        config.params.forEach { key, value ->
            binding?.setVariable(key, value)
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.unbind()
        binding = null
        isBindingInit = false
    }

    fun getBinding(): BINDING {
        if (isBindingInit) {
            return binding!!
        } else {
            throw NullPointerException("binding has not init!")
        }
    }

    protected fun nav(): NavController {
        return NavHostFragment.findNavController(this)
    }
}