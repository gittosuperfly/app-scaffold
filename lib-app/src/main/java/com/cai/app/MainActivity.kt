package com.cai.app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import com.cai.app.databinding.ActivityMainBinding
import com.cai.architecture.ui.databinding.DataBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity<ActivityMainBinding>() {

    private val viewModel: MainShareViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_main

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