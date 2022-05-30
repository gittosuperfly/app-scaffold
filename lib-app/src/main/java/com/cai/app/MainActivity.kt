package com.cai.app

import android.widget.Toast
import androidx.activity.viewModels
import com.cai.architecture.ui.databinding.DataBindingActivity
import com.cai.architecture.ui.databinding.DataBindingConfig
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity() {
    override fun getDataBindingConfig() = DataBindingConfig(R.layout.activity_main)
}