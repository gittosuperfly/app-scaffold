package com.cai.app.feature.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cai.app.R
import com.cai.base.kotlin_ext.safeCreator
import com.cai.base.widget.bottombar.BottomNavigationView
import com.cai.base.widget.bottombar.IMenuListener

class MainTabView : ConstraintLayout {
    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context)
    }

    lateinit var rootView: ViewGroup
    lateinit var viewPager: ViewPager2
    lateinit var bottomNavBarView: BottomNavigationView

    val tabItems = mutableListOf<MainTabHosts>()


    private fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.layout_view_main_tab, this, true)
        rootView = findViewById(R.id.layout_root)
        viewPager = findViewById(R.id.view_pager)
        bottomNavBarView = findViewById(R.id.bottom_nav_bar)
    }

    fun setTabItemList(items: List<MainTabHosts>) {
        tabItems.clear()
        tabItems.addAll(items)
        updateView()
    }


    fun setOnTabClickListener(listener: IMenuListener) {
        bottomNavBarView.setMenuListener(listener)
    }

    private fun updateView() {
        viewPager.apply {
            isUserInputEnabled = false
            offscreenPageLimit = tabItems.size
            adapter = object : FragmentStateAdapter(findFragment() as Fragment) {
                override fun getItemCount() = tabItems.size
                override fun createFragment(position: Int): Fragment {
                    return tabItems[position].fragmentClass.safeCreator()!!
                }
            }
        }

        bottomNavBarView.apply {
            for (i in 0 until tabItems.size) {
                setItem(i, tabItems[i].text, tabItems[i].icon)
            }
            enableAnimation(false)
            enableItemHorizontalTranslation(false)
            setupWithViewPager2(viewPager)
        }
    }
}