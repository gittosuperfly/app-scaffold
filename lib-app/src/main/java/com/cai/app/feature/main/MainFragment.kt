package com.cai.app.feature.main

import android.os.Bundle
import android.view.View
import com.cai.app.R
import com.cai.app.databinding.FragmentMainBinding
import com.cai.architecture.ui.databinding.DataBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : DataBindingFragment<FragmentMainBinding>() {

    override fun getLayoutRes() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainTab.setTabItemList(MainTabHosts.defaultTabs)
    }


}