package com.cai.app.feature.settings

import android.os.Bundle
import android.view.View
import com.cai.app.BR
import com.cai.app.R
import com.cai.app.databinding.FragmentSettingsBinding
import com.cai.architecture.ui.databinding.DataBindingConfig
import com.cai.architecture.ui.databinding.DataBindingFragment

class SettingsFragment : DataBindingFragment<FragmentSettingsBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_settings

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.click = ClickProxy()
    }

    inner class ClickProxy {
        fun toAbout() {

        }
    }
}