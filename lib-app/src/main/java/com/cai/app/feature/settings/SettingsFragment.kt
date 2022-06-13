package com.cai.app.feature.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cai.app.databinding.FragmentSettingsBinding
import com.cai.architecture.ui.base.BaseFragment
import com.cai.base.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment() {

    private val binding: FragmentSettingsBinding by viewBinding()

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}