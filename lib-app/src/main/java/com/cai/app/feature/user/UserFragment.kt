package com.cai.app.feature.user

import android.os.Bundle
import android.view.View
import com.cai.app.BR
import com.cai.app.R
import com.cai.app.databinding.FragmentUserBinding
import com.cai.architecture.ui.databinding.DataBindingConfig
import com.cai.architecture.ui.databinding.DataBindingFragment

class UserFragment : DataBindingFragment<FragmentUserBinding>() {
    override fun getLayoutRes() = R.layout.fragment_user

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.click = ClickProxy()
    }

    inner class ClickProxy {
        fun toSetting() {
            nav().navigate(R.id.action_mainFragment_to_settingsFragment)
        }
    }
}