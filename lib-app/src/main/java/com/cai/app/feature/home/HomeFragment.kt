package com.cai.app.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cai.app.databinding.FragmentHomeBinding
import com.cai.architecture.ui.base.BaseFragment
import com.cai.base.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private val binding: FragmentHomeBinding by viewBinding()

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View {
        return binding.root
    }
}