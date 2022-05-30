package com.cai.architecture.ui.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DataBindingActivity : AppCompatActivity() {

    private var binding: ViewDataBinding? = null

    protected abstract fun getDataBindingConfig(): DataBindingConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = getDataBindingConfig()
        binding = DataBindingUtil.setContentView(this, config.layoutId)
        binding?.lifecycleOwner = this
        config.params.forEach { key, value ->
            binding?.setVariable(key, value)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.unbind()
        binding = null
    }
}
