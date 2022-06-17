package com.cai.app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.cai.app.databinding.ActivityMainBinding
import com.cai.architecture.ui.base.BaseActivity
import com.cai.base.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainShareViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        subscribe()
        initData()
    }

    private fun subscribe() {
        viewModel.statusBarDark.observe(this) {
            val controller = WindowCompat.getInsetsController(window, window.decorView)
            controller.isAppearanceLightStatusBars = it
        }
    }

    private fun initData() {
        viewModel.statusBarDark.value = true
    }
}