package com.cai.app.feature.find

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cai.app.databinding.FragmentFindBinding
import com.cai.architecture.ui.base.BaseFragment
import com.cai.base.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindFragment : BaseFragment() {

    private val binding:FragmentFindBinding by viewBinding()

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View {
        return binding.root
    }
}