package com.cai.app

import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import com.cai.architecture.ui.databinding.DataBindingActivity
import com.cai.architecture.ui.databinding.DataBindingConfig
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity() {
    private val viewModel: MainShareViewModel by viewModels()
    override fun getDataBindingConfig() = DataBindingConfig(R.layout.activity_main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observerInit()
        viewModel.statusBarDark.value = true
    }
    private fun observerInit() {
        viewModel.statusBarDark.observe(this) {
            val controller = ViewCompat.getWindowInsetsController(window.decorView)
            controller?.isAppearanceLightStatusBars = it
        }
    }
}