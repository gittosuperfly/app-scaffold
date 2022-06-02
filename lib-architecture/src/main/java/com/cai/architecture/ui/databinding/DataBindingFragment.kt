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

    lateinit var binding: BINDING

    protected abstract fun getLayoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), root, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    protected fun nav(): NavController {
        return NavHostFragment.findNavController(this)
    }
}