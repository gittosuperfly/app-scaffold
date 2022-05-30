package com.cai.app.feature

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.cai.app.BR
import com.cai.app.MainShareViewModel
import com.cai.app.R
import com.cai.app.databinding.FragmentMainBinding
import com.cai.architecture.ui.databinding.DataBindingConfig
import com.cai.architecture.ui.databinding.DataBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : DataBindingFragment<FragmentMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private val shareViewModel: MainShareViewModel by activityViewModels()

    override fun getDataBindingConfig() = DataBindingConfig(R.layout.fragment_main)
        .addParam(BR.vm, viewModel)
        .addParam(BR.click, ClickProxy())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBinding().bottomBar.apply {
            setItem(0, "111", R.drawable.ic_launcher_background)
            setItem(1, "111", R.drawable.ic_launcher_background)
            setItem(2, "111", R.drawable.ic_launcher_background)
            setItem(3, "111", R.drawable.ic_launcher_background)
        }
    }

    inner class ClickProxy {
        fun click() {
            Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show()
        }
    }
}