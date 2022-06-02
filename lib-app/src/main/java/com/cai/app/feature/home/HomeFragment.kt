package com.cai.app.feature.home

import com.cai.app.R
import com.cai.app.databinding.FragmentHomeBinding
import com.cai.architecture.ui.databinding.DataBindingConfig
import com.cai.architecture.ui.databinding.DataBindingFragment

class HomeFragment : DataBindingFragment<FragmentHomeBinding>() {
    override fun getLayoutRes() = R.layout.fragment_home
}