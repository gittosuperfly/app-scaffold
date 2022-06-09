package com.cai.app.feature.main

import androidx.fragment.app.Fragment
import com.cai.app.R
import com.cai.app.feature.find.FindFragment
import com.cai.app.feature.home.HomeFragment
import com.cai.app.feature.user.UserFragment

enum class MainTabHosts constructor(
    val text: String,
    val icon: Int,
    val fragmentClass: Class<out Fragment>
) {
    HOME("首页", R.drawable.ic_launcher_foreground, HomeFragment::class.java),
    FIND("发现", R.drawable.ic_launcher_foreground, FindFragment::class.java),
    USER("用户", R.drawable.ic_launcher_foreground, UserFragment::class.java);

    companion object {
        val defaultTabs = listOf(HOME, FIND, USER)
    }
}