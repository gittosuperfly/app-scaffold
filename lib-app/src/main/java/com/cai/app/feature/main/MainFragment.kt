package com.cai.app.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cai.app.databinding.FragmentMainBinding
import com.cai.architecture.ui.base.BaseFragment
import com.cai.base.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment() {

    private val binding: FragmentMainBinding by viewBinding()

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainTab.setTabItemList(MainTabHosts.defaultTabs)
    }


}