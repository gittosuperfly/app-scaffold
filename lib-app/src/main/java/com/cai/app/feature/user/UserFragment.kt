package com.cai.app.feature.user

import com.cai.app.R
import com.cai.app.databinding.FragmentUserBinding
import com.cai.architecture.ui.databinding.DataBindingConfig
import com.cai.architecture.ui.databinding.DataBindingFragment

class UserFragment : DataBindingFragment<FragmentUserBinding>() {
    override fun getDataBindingConfig() = DataBindingConfig(R.layout.fragment_user)
}