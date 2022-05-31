package com.cai.app.feature

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cai.app.BR
import com.cai.app.MainShareViewModel
import com.cai.app.R
import com.cai.app.databinding.FragmentMainBinding
import com.cai.app.feature.find.FindFragment
import com.cai.app.feature.home.HomeFragment
import com.cai.app.feature.user.UserFragment
import com.cai.architecture.ui.databinding.DataBindingConfig
import com.cai.architecture.ui.databinding.DataBindingFragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode
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
        getBinding().fragmentPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 3
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> HomeFragment()
                    1 -> FindFragment()
                    2 -> UserFragment()
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
        getBinding().bottomNavBar.apply {
            setItem(0, "home", R.drawable.ic_launcher_background)
            setItem(1, "find", R.drawable.ic_launcher_background)
            setItem(2, "user", R.drawable.ic_launcher_background)
            enableAnimation(false)
            setupWithViewPager2(getBinding().fragmentPager)
        }

    }

    inner class ClickProxy {
        fun click() {
            Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show()
        }
    }
}